package com.java.managedbeans;

import com.java.model.Person;
import com.java.service.PersonService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;

/**
 * Represents bean class for adding new person in dialog on UI layer
 */
@ManagedBean(name="saveData")
@ViewScoped
public class DialogCreation extends BasicBean implements Serializable {

    private Person person;

    @PostConstruct
    public void init() {
        person = new Person();
    }

    @ManagedProperty("#{personService}")
    private PersonService service;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void save() throws IOException {
        service.savePerson(person);
        reload();
    }

    public void setService(PersonService service) {
        this.service = service;
    }
}
