package com.housinghack.datasources;

import com.housinghack.entities.AttributeCollection;
import com.housinghack.entities.Endpoints;

import org.springframework.web.client.RestTemplate;

/**
 * Created by prashanth.a on 26/04/15.
 */
public class InvitationDataSource {

    public Boolean checkInvite(String rid){
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/invite?rid=" + rid;
        return restTemplate.getForObject(attributesPath, Boolean.class);
    }

}
