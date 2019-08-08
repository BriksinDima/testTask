package com.java.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Represents a singleton class for getting connection to db
 * */
public class SessionManager {
    private static SessionManager ourInstance = new SessionManager();

    public static SessionManager getInstance() {
        return ourInstance;
    }

    public SqlSession  getSession(){
        SqlSessionFactory sqlSessionFactory;
        SqlSession session = null;
        try{
            Reader reader = Resources
                    .getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
             session = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }

    private SessionManager() {
    }
}
