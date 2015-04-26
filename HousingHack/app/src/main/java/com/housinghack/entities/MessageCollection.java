package com.housinghack.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by prashanth.a on 26/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageCollection {
    public List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
