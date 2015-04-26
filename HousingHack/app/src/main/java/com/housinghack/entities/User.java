package com.housinghack.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by prashanth.a on 25/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String name;
    public String id;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
