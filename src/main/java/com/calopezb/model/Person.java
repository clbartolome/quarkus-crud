package com.calopezb.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class Person extends PanacheEntity {
    public String name;

    @Column(unique = true)
    public String email;
}