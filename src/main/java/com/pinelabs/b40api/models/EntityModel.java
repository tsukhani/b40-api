package com.pinelabs.b40api.models;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class EntityModel {

    @Id
    @GeneratedValue
    protected Long id;

    protected LocalDateTime createdAt;

    protected LocalDateTime deletedAt;

    @PrePersist
    public void generateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

}
