package com.witcher.kicker.domain.zigzag.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldItem {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("required")
    private boolean required;

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    public FieldItem(String name, String type, boolean required, String id, String value) {
        this.name = name;
        this.type = type;
        this.required = required;
        this.id = id;
        this.value = value;
    }

    public FieldItem(String name, String type, boolean required, String id) {
        this.name = name;
        this.type = type;
        this.required = required;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
