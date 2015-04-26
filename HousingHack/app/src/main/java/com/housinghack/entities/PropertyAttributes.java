package com.housinghack.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by prashanth.a on 25/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyAttributes {
    private String
            formatted_rent,
            apartment_type,
            lease_type,
            furnish_type,
            property_type,
            area,
            formatted_security_deposit,
            bedroom_count,
            bathroom_count,
            is_rent_negotiable;

    public String getFormatted_rent() {
        return formatted_rent;
    }

    public void setFormatted_rent(String formatted_rent) {
        this.formatted_rent = formatted_rent;
    }

    public String getApartment_type() {
        return apartment_type;
    }

    public void setApartment_type(String apartment_type) {
        this.apartment_type = apartment_type;
    }

    public String getLease_type() {
        return lease_type;
    }

    public void setLease_type(String lease_type) {
        this.lease_type = lease_type;
    }

    public String getFurnish_type() {
        return furnish_type;
    }

    public void setFurnish_type(String furnish_type) {
        this.furnish_type = furnish_type;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFormatted_security_deposit() {
        return formatted_security_deposit;
    }

    public void setFormatted_security_deposit(String formatted_security_deposit) {
        this.formatted_security_deposit = formatted_security_deposit;
    }

    public String getBedroom_count() {
        return bedroom_count;
    }

    public void setBedroom_count(String bedroom_count) {
        this.bedroom_count = bedroom_count;
    }

    public String getBathroom_count() {
        return bathroom_count;
    }

    public void setBathroom_count(String bathroom_count) {
        this.bathroom_count = bathroom_count;
    }

    public String getIs_rent_negotiable() {
        return is_rent_negotiable;
    }

    public void setIs_rent_negotiable(String is_rent_negotiable) {
        this.is_rent_negotiable = is_rent_negotiable;
    }
}
