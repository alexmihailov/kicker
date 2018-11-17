package com.witcher.kicker.database.entity;

import javax.persistence.*;

@Entity(name = "user_info")
public class InformationBody {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
