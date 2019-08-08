package com.java.mappers;

import com.java.handlers.HasValueEnumTypeHandler;
import com.java.handlers.UUIDTypeHandler;
import com.java.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

/**
 * Represents an interface with queries to person table
 * */
public interface PersonMapper {

    @Results(id = "personResult", value = {
            @Result(property = "id", column = "id", typeHandler= UUIDTypeHandler.class),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "secondName", column = "second_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "gender", column = "gender", typeHandler= HasValueEnumTypeHandler.class)

    })

    @Select("select * from person where id = #{id,javaType=UUID,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    Person getPersonById(@Param("id") UUID id);

    @ResultMap(value = "personResult")
    @Select("select * from person")
    List<Person> getPersonList();

    @Insert("INSERT into person(id, first_name, second_name, last_name, birth_date, gender)" +
            " VALUES(#{id,javaType=UUID,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, #{firstName}, #{secondName},  #{lastName},  #{birthDate},  #{gender,javaType=Gender,typeHandler=HasValueEnumTypeHandler})")
    void insertPerson(Person person);

    @Delete("DELETE FROM public.person WHERE id = #{id,javaType=UUID,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    void deletePersonById(@Param("id") UUID id);

    @Update("UPDATE public.person " +
            " SET first_name= #{firstName}, second_name=#{secondName}, last_name=#{lastName}, birth_date=#{birthDate}, gender = #{gender,javaType=Gender,typeHandler=HasValueEnumTypeHandler} " +
            " WHERE id= #{id,javaType=UUID,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    void updatePerson(Person person);

}
