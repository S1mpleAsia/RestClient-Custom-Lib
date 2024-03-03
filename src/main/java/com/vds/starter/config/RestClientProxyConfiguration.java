package com.vds.starter.config;

public class RestClientProxyConfiguration {
    // Proxy Configuration
    private final String host;
    private final int port;
    private final String scheme;

    // Optional Proxy authentication
    private final String proxyUsername;
    private final String proxyPassword;

    public RestClientProxyConfiguration(String host, int port, String scheme, String proxyUsername, String proxyPassword) {
        this.host = host;
        this.port = port;
        this.scheme = scheme;
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
    }

    public RestClientProxyConfiguration(String host, int port, String scheme) {
        this(host, port, scheme, null, null);
    }

}
