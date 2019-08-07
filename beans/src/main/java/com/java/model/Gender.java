package com.java.model;

public enum Gender implements HasValue{

    MALE("Male"), FEMALE("Female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
