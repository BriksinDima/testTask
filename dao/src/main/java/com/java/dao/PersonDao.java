package com.java.dao;

import com.java.model.Person;

import java.util.List;

/**
 * Represents an interface of dao person
 * */
public interface PersonDao {

    List<Person> findAll();
    Person findById(String id);
    void save(Person person);
    void deleteById(String id);
    void update(Person person,String id);
}
