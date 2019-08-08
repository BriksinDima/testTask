package com.java.managedbeans;

import com.java.model.Gender;

import javax.faces.bean.ManagedBean;
/**
 * Represents bean class for showing current value from Gender enumeration on UI layer
 */
@ManagedBean(name="genderBean")
public class GenderBean {
    public GenderBean() {
    }

    public String getValue(Gender gender) {
        return gender.getValue();
    }
}