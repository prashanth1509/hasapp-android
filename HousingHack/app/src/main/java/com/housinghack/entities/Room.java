package com.housinghack.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by prashanth.a on 25/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    public String id;

    public String attributesId;

    public List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getAttributesId() {
        return attributesId;
    }

    public void setAttributesId(String attributesId) {
        this.attributesId = attributesId;
    }
}
