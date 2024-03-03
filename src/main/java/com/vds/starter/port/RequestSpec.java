package com.vds.starter.port;

import java.util.Map;

public interface RequestSpec {
    RequestSpec url(String url);
    RequestSpec headers(Map<String, Object> headers);
    ResponseSpec retrieve();
}
