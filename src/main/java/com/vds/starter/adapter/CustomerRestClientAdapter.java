package com.vds.starter.adapter;

import com.vds.starter.config.RestClientConfiguration;
import com.vds.starter.port.CustomRestClient;
import com.vds.starter.port.RequestSpec;
import com.vds.starter.service.RequestSpecImpl;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;

public class CustomerRestClientAdapter implements CustomRestClient {
    private CloseableHttpClient httpClient;
    private HttpClientContext httpClientContext;
    private RestClientConfiguration clientConfiguration;

    public CustomerRestClientAdapter(CloseableHttpClient httpClient, HttpClientContext httpClientContext, RestClientConfiguration clientConfiguration) {
        this.httpClient = httpClient;
        this.httpClientContext = httpClientContext;
        this.clientConfiguration = clientConfiguration;
    }

    public CustomerRestClientAdapter(RestClientConfiguration config) {
        this.httpClient = createHttpClient(config);
    }

    private CloseableHttpClient createHttpClient(RestClientConfiguration config) {
        // Configure HttpClient based on options (implementation omitted)
        return HttpClients.createDefault();
    }

    public CustomerRestClientAdapter() {
        this.httpClient = HttpClients.createDefault();
    }

    @Override
    public RequestSpec get() {
        return new RequestSpecImpl(new HttpGet(), new HashMap<>(), this.httpClient);
    }

    @Override
    public RequestSpec delete() {
        return new RequestSpecImpl(new HttpDelete(), new HashMap<>(), this.httpClient);
    }

    @Override
    public RequestSpec post() {
        return new RequestSpecImpl(new HttpPost(), new HashMap<>(), this.httpClient);
    }

    @Override
    public RequestSpec put() {
        return new RequestSpecImpl(new HttpDelete(), new HashMap<>(), this.httpClient);
    }
}
