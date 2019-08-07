package com.java.dao;

import com.java.mappers.PersonMapper;
import com.java.model.Gender;
import com.java.model.Person;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class PersonDaoMyBatisImpl implements PersonDao {

    private SessionManager sessionManager = SessionManager.getInstance();

    public  Person findById(String id){
        UUID uuid = UUID.fromString(id);
        SqlSession session = sessionManager.getSession();
        Person person = session.getMapper(PersonMapper.class).getPersonById(uuid);
        session.close();
        return person;
    }

    public  List<Person> findAll(){
        SqlSession session = sessionManager.getSession();
        List<Person> personList =  session.getMapper(PersonMapper.class).getPersonList();
        session.close();
        return personList;
    }

    public void save(Person person){
        UUID uuid = UUID.randomUUID();
        person.setId(uuid);
        SqlSession session = sessionManager.getSession();
        session.getMapper(PersonMapper.class).insertPerson(person);
        session.commit();
        session.close();
    }

    public void deleteById(String id){
        UUID uuid = UUID.fromString(id);
        SqlSession session = sessionManager.getSession();
        session.getMapper(PersonMapper.class).deletePersonById(uuid);
        session.commit();
        session.close();
    }

    public void update(Person person, String id){
        UUID uuid = UUID.fromString(id);
        SqlSession session = sessionManager.getSession();
        person.setId(uuid);
        session.getMapper(PersonMapper.class).updatePerson(person);
        session.commit();
        session.close();
        System.out.println(person);
    }
}
