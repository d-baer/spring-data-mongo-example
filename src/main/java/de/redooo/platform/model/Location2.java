package de.redooo.platform.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Location2 {

    @Field("id")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
