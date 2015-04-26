package com.housinghack.datasources;

import com.housinghack.entities.Endpoints;
import com.housinghack.entities.User;
import com.housinghack.entities.UserCollection;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by prashanth.a on 26/04/15.
 */
public class UsersDataSource {

    public Boolean addUser(String rid, String username) {
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/users/add?rid={rid}&user_name={username}";
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(attributesPath, Boolean.class, rid, username);
    }

    public UserCollection getUsers(String rid) {
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/users?rid={rid}";
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(attributesPath, UserCollection.class, rid);
    }
}
