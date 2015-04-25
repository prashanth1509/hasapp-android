package com.housinghack.datasources;

import com.housinghack.entities.AttributeCollection;
import com.housinghack.entities.Endpoints;

import org.springframework.web.client.RestTemplate;

/**
 * Created by prashanth.a on 26/04/15.
 */
public class AttributeDataSource {

    public AttributeDataSource() {
    }

    public AttributeCollection getAttributes(String rid){
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/attributes?rid=" + rid;
        return restTemplate.getForObject(attributesPath, AttributeCollection.class);
    }

    public Boolean addFeedBack(Boolean feedback, String rid, String username, String aid){
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/attributes/feedback?rid=" + rid + "&username=" + username + "&attribute_id=" + aid + "&feedback=" + feedback;
        restTemplate.getForObject(attributesPath, String.class);
        return true;
    }


}
