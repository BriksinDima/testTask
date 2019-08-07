package com.java.managedbeans;

import com.java.model.Person;
import com.java.service.PersonService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="detailsDialog")
@SessionScoped
public class DialogDetails extends BasicBean{

    private String editPersonId;

    private Person person;

    @PostConstruct
    public void init() {
        person = new Person();
    }

    public String getEditPersonId() {
        return editPersonId;
    }

    public void setEditPersonId(String editPersonId) {
        this.editPersonId = editPersonId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManagedProperty("#{personService}")
    private PersonService service;

    public void setService(PersonService service) {
        this.service = service;
    }

    public void update(){
        System.out.println(this.person);
        System.out.println(this.editPersonId);
        service.updatePerson(this.person, this.editPersonId);
        reload();
    }

    public void editAction() {

        Person person = service.getPersonById(editPersonId);
        System.out.println(person);
        this.person = person;
    }

    public void delete(){
        System.out.println(person);
        service.deletePerson(editPersonId);
        reload();
    }


}
