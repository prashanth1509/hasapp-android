package com.housinghack.entities;

import java.util.List;

/**
 * Created by prashanth.a on 25/04/15.
 */
public class Attribute {
    public String atid, type, text, title;
    public List<User> votesUp;
    public List<User> votesDown;

    public String getAtid() {
        return atid;
    }

    public void setAtid(String atid) {
        this.atid = atid;
    }

    public String getId() {
        return atid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getVotesUp() {
        return votesUp;
    }

    public void setVotesUp(List<User> votesUp) {
        this.votesUp = votesUp;
    }

    public List<User> getVotesDown() {
        return votesDown;
    }

    public void setVotesDown(List<User> votesDown) {
        this.votesDown = votesDown;
    }
}
