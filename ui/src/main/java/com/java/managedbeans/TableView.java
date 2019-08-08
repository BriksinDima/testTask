package com.java.managedbeans;

import com.java.model.Person;
import com.java.service.PersonService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
/**
 * Represents bean class for control data in the table on UI layer
 */
@ManagedBean(name="dtBasicView")
@ViewScoped
public class TableView implements Serializable {

    private List<Person> persons;

    @ManagedProperty("#{personService}")
    private PersonService service;

    @PostConstruct
    public void init() {
        if (persons == null) {
            persons = service.getPersonList();
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setService(PersonService service) {
        this.service = service;
    }
}