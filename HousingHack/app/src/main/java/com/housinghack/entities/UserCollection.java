package com.housinghack.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by susee on 26/4/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserCollection {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
