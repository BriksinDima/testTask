package com.java.managedbeans;

import com.java.model.Gender;
import com.java.model.Person;
import com.java.service.PersonService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;

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
        System.out.println(this.person);

        Gender gender = this.person.getGender();
        Person person = this.person;
        person.setGender(gender);
        service.savePerson(person);
        reload();
    }

    public void setService(PersonService service) {
        this.service = service;
    }
}
