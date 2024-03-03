package com.vds.starter.port;

public interface RequestWithPayloadSpec extends RequestSpec {
    RequestWithPayloadSpec payload(Object payload);
}
