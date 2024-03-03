package com.vds.starter.model;

public class Cat {
    private final String id;
    private final String url;
    private final String width;
    private final String height;

    public Cat(String id, String url, String width, String height) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}
