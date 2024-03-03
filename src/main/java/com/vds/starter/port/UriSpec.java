package com.vds.starter.port;

import java.util.Map;

public interface UriSpec<S> {
    S uri(String url, Object... uriVariable);
    S uri(String url, Map<String, Object> uriVariable);
}
