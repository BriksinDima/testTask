package com.java.service;

import com.java.dao.PersonDao;
import com.java.dao.PersonDaoMyBatisImpl;
import com.java.model.Person;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Represents bean class for getting person data
 * */
@ManagedBean(name = "personService")
@ApplicationScoped
public class PersonService {

    private PersonDao personDao;

    @PostConstruct
    public void init() {
        personDao = new PersonDaoMyBatisImpl();
    }

    public List<Person> getPersonList() {
       List<Person> personList = personDao.findAll();
       return personList;
    }

    public Person getPersonById(String id){
        Person person = personDao.findById(id);
        return person;
    }

    public void savePerson(Person person){
        personDao.save(person);
    }

    public void deletePerson(String id){
        personDao.deleteById(id);
    }
    public void updatePerson(Person person,String id){
        personDao.update(person, id);
    }
}