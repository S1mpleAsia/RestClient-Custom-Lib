package com.vds.starter.port;

import org.springframework.core.ParameterizedTypeReference;

public interface ResponseSpec {
    <T> T body(Class<T> responseType);
    <T> T body(ParameterizedTypeReference<T> responseType);
}
