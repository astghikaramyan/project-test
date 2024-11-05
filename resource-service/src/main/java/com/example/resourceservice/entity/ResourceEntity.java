package com.example.resourceservice.entity;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "resource")
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "data")
    private Blob data;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Blob getData() {
        return data;
    }

    public void setData(final Blob data) {
        this.data = data;
    }
}
