package com.vds.starter.service;

import com.vds.starter.port.ResponseSpec;
import org.springframework.core.ParameterizedTypeReference;

public class ResponseSpecImpl implements ResponseSpec {
    private final int statusCode;
    private final String responseBody;

    public ResponseSpecImpl(int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }


    @Override
    public <T> T body(Class<T> responseType) {
        if(statusCode == 200) return responseType.cast(responseBody);
        return null;
    }


    @Override
    public <T> T body(ParameterizedTypeReference<T> responseType) {
        if(statusCode == 200) return null;
        return null;
    }
}
