package com.java.model;


/**
 * Represents an enumeration gender
 * */
public enum Gender implements HasValue{

    MALE("Male"), FEMALE("Female");

    private String value;
    /**
     * Set value of enum.
     * */
    Gender(String value) {
        this.value = value;
    }
    /**
     * Returns value of enum.
     * */
    public String getValue() {
        return value;
    }
}
