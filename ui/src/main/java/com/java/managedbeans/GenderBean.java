package com.java.managedbeans;

import com.java.model.Gender;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean(name="genderBean")
public class GenderBean {
    public GenderBean() {
    }

    public String getValue(Gender gender) {
        return gender.getValue();
    }
}