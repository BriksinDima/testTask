package com.java.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
/**
 * Represents a person
 * */
public class Person {

    /**
     *  Represents a person's unique identifier
     */
    private UUID Id;

    private String firstName;

    private String secondName;

    private String lastName;

    private Date birthDate;

    /**
     *  Represents a person's gender
     */
    private Gender gender;

    /** Gets the person’s unique identifier.
     * @return A UUID representing the person’s unique identifier.
     *
     */
    public UUID getId() {
        return Id;
    }

    /** Sets the person’s unique identifier.
     * @param id A UUID containing the person’s unique identifier.
     *
     */
    public void setId(UUID id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /** Gets the person’s gender.
     * @return A Gender representing the person’s gender.
     *
     */
    public Gender getGender() {
        return gender;
    }

    /** Sets the person’s gender.
     * @param gender A Gender containing the person’s gender.
     *
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /** Creates a person without params
     *
     */
    public Person() {
    }

    /** Creates a person with the specified name, gender, birthday.
     * @param id The person’s id.
     * @param firstName The person’s first name.
     * @param lastName The person’s last name.
     * @param secondName The person’s second name.
     * @param birthDate The person’s birthday.
     * @param gender The person’s gender.
     */
    public Person(UUID id, String firstName, String secondName, String lastName, Date birthDate, Gender gender) {
        Id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(Id, person.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
