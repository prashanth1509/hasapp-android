package com.housinghack.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 25/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeCollection {
    public String id;
    public List<Attribute> attributeList;

    public AttributeCollection() {
        this.attributeList = new ArrayList<Attribute>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public void addAttribute(Attribute a) {

        //Use set data structure instead

        if (!this.attributeList.contains(a))
            this.attributeList.add(a);
    }
}
