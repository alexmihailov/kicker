package com.witcher.kicker.domain.kupipotter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KupipotterRequest {

    @JsonProperty("hit")
    private Hit hit;

    @JsonProperty("fields")
    private List<FieldItem> fields;

    public KupipotterRequest(Hit hit, List<FieldItem> fields) {
        this.hit = hit;
        this.fields = fields;
    }

    public Hit getHit() {
        return hit;
    }

    public List<FieldItem> getFields() {
        return fields;
    }
}
