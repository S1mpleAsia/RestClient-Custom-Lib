package com.vds.starter.config;

public class CustomRestClientConfiguration implements RestClientConfiguration {
    private int requestTimeoutInSeconds = 300;
    // Optional settings to validate SSL certificate.
    private boolean ignoreInvalidSslCertificates = false;
    private RestClientProxyConfiguration proxyConfiguration = null;

    public CustomRestClientConfiguration withProxy(RestClientProxyConfiguration proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
        return this;
    }

    /**
     * Skip all validation of SSL Certificates.  This is insecure and highly discouraged!
     * @return CustomRestClientConfiguration instance.
     */
    public CustomRestClientConfiguration useInsecureSslCertificates() {
        this.ignoreInvalidSslCertificates = true;
        return this;
    }

    public CustomRestClientConfiguration withTimeout(int requestTimeoutInSeconds) {
        this.requestTimeoutInSeconds = requestTimeoutInSeconds;
        return this;
    }

    @Override
    public RestClientProxyConfiguration getProxyConfiguration() {
        return proxyConfiguration;
    }

    @Override
    public boolean getIgnoreInvalidSslCertificates() {
        return ignoreInvalidSslCertificates;
    }

    @Override
    public int getRequestTimeoutInSeconds() {
        return requestTimeoutInSeconds;
    }
}
