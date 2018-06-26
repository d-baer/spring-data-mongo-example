package de.redooo.platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Palace {

    @Id
    private String id;
    private String name;
    private Location location;
    private Location2 location2;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location2 getLocation2() {
        return location2;
    }

    public void setLocation2(Location2 location2) {
        this.location2 = location2;
    }
}
