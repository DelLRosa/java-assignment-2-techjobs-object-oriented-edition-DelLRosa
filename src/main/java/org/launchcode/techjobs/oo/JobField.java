package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    int id;
    int nextId=1;
    String value;


    //Constructors
    public JobField(){
        this.id=nextId;
        this.nextId++;
    }

    public JobField(String value){
        this();
        this.value=value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return value;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
