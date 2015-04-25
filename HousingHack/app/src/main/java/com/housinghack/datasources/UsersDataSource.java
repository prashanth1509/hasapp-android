package com.housinghack.datasources;

import com.housinghack.entities.Endpoints;
import com.housinghack.entities.User;

import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by prashanth.a on 26/04/15.
 */
public class UsersDataSource {

    public Boolean addUser(String rid, String username){
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/users/add?rid=" + rid + "&user_name=" + username;
        return restTemplate.getForObject(attributesPath, Boolean.class);
    }

    public List<User> getUsers(String rid){
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/users/?rid=" + rid;
        return restTemplate.getForObject(attributesPath, List.class);
    }
}
