package com.clinicmanagementsystem.cms.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Medication extends Auditable {

    @Id
    ObjectId id;

    String name;

    String description;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
