package com.vds.starter.adapter;

import com.vds.starter.port.CustomRestClient;

public class CustomRestClientBuilder {
    public static CustomRestClient build() {
        return new CustomerRestClientAdapter();
    }
}
