package com.vds.starter.service;

import com.vds.starter.port.RequestSpec;
import com.vds.starter.port.ResponseSpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class RequestSpecImpl implements RequestSpec {
    private final HttpRequestBase request;
    private final Map<String, Object> headers;
    private final CloseableHttpClient httpClient;
    private Object payload;

    public RequestSpecImpl(HttpRequestBase request, Map<String, Object> headers, CloseableHttpClient httpClient) {
        this.request = request;
        this.headers = headers;
        this.httpClient = httpClient;
    }

    public RequestSpecImpl(HttpRequestBase request, Map<String, Object> headers, CloseableHttpClient httpClient, Object payload) {
        this(request, headers, httpClient);
        this.payload = payload;
    }

    @Override
    public RequestSpec headers(Map<String, Object> headers) {
        this.headers.putAll(headers);
        return this;
    }

    @Override
    public ResponseSpec retrieve() {
        try {
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                request.addHeader(header.getKey(), header.getValue().toString());
            }
            if (payload != null && request instanceof HttpEntityEnclosingRequestBase) {
                ((HttpEntityEnclosingRequestBase) request).setEntity(new StringEntity(payload.toString()));
            }
            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            return new ResponseSpecImpl(response.getStatusLine().getStatusCode(), responseBody);
        } catch (IOException e) {
            throw new RuntimeException("Error executing request", e);
        } finally {
            request.releaseConnection();
        }
    }

    public RequestSpec url(String url) {
        request.setURI(URI.create(url));
        return this;
    }
}
