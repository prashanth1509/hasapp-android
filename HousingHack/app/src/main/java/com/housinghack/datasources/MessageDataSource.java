package com.housinghack.datasources;

import com.housinghack.entities.Endpoints;
import com.housinghack.entities.Message;
import com.housinghack.entities.MessageCollection;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by prashanth.a on 26/04/15.
 */
public class MessageDataSource {

    public MessageCollection getContents(String rid, int lastTimeStamp) {
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/content?rid={rid}&timestamp={lastTimeStamp}";
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(attributesPath, MessageCollection.class, rid, lastTimeStamp);
    }

    public Boolean sendMessage(Boolean feedback, String rid, String username, String aid, String state, String text, String type) {
        RestTemplate restTemplate = new RestTemplate();
        String attributesPath = Endpoints.BASE + "/content/add?rid={rid}&user_name={username}";
        if (!aid.isEmpty())
            attributesPath += "&attribute_id={aid}";
        if (!state.isEmpty())
            attributesPath += "&vote={state}";
        if (!text.isEmpty())
            attributesPath += "&text={text}";
        if (!type.isEmpty())
            attributesPath += "&type={type}";
        return restTemplate.getForObject(attributesPath, Boolean.class, rid, username, aid, state, text, type);
    }
}
