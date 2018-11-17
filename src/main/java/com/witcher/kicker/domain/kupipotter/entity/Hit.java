package com.witcher.kicker.domain.kupipotter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hit {

    @JsonProperty("page_id")
    private long pageId;

    @JsonProperty("ab_id")
    private long abId;

    @JsonProperty("referer")
    private String refer;

    @JsonProperty("uri")
    private String uri;

    public Hit(long pageId, long abId, String refer, String uri) {
        this.pageId = pageId;
        this.abId = abId;
        this.refer = refer;
        this.uri = uri;
    }

    public long getPageId() {
        return pageId;
    }

    public long getAbId() {
        return abId;
    }

    public String getRefer() {
        return refer;
    }

    public String getUri() {
        return uri;
    }
}
