package com.witcher.kicker.database.entity;

import javax.persistence.*;

@Entity(name = "kupipotter")
public class InformationBody {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body_text", nullable = false,
            insertable = false,
            updatable = false)
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
