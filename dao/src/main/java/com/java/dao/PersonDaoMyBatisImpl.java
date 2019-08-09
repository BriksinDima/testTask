package com.java.dao;

import com.java.mappers.PersonMapper;
import com.java.model.Person;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents an implementation  of
 * interface dao person for mybatis library
 * */
public class PersonDaoMyBatisImpl implements PersonDao {

    private SessionManager sessionManager = SessionManager.getInstance();

    public  Person findById(String id){
        UUID uuid = UUID.fromString(id);
        Person person;
        try(SqlSession session = sessionManager.getSession()){
             person = session.getMapper(PersonMapper.class).getPersonById(uuid);
        }
        return person;
    }

    public  List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        try(SqlSession session = sessionManager.getSession()) {
            personList = session.getMapper(PersonMapper.class).getPersonList();
        }
        return personList;
    }

    public void save(Person person){
        person.setId(UUID.randomUUID());
        try( SqlSession session = sessionManager.getSession()){
            session.getMapper(PersonMapper.class).insertPerson(person);
            session.commit();
        }
    }

    public void deleteById(String id){
        try(SqlSession session = sessionManager.getSession()) {
            session.getMapper(PersonMapper.class).deletePersonById(UUID.fromString(id));
            session.commit();
        }
    }

    public void update(Person person, String id){
        try(SqlSession session = sessionManager.getSession()) {
            person.setId(UUID.fromString(id));
            session.getMapper(PersonMapper.class).updatePerson(person);
            session.commit();
        }
    }
}
