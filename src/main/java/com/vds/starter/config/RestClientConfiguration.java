package com.vds.starter.config;

public interface RestClientConfiguration {
    RestClientProxyConfiguration getProxyConfiguration();
    boolean getIgnoreInvalidSslCertificates();
    int getRequestTimeoutInSeconds();

}
