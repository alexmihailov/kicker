package com.witcher.kicker.domain.rosmean.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RosmeanRequest {

    @JsonProperty("hit")
    private Hit hit;

    @JsonProperty("fields")
    private List<FieldItem> fields;

    public RosmeanRequest(Hit hit, List<FieldItem> fields) {
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
