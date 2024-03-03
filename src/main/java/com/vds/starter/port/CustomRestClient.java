package com.vds.starter.port;

import com.vds.starter.adapter.CustomRestClientBuilder;

public interface CustomRestClient {
    RequestSpec get();
    RequestSpec delete();
    RequestSpec post();
    RequestSpec put();
    static CustomRestClient create() {
        return CustomRestClientBuilder.build();
    }
}
