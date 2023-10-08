package com.example.portfoliovault.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Logger;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private BsonValue userId;
    private LinkedList<Education> educations;
    private LinkedList<Experience> experiences;

    public BsonValue getUserId() {
        return userId;
    }

    public void setUserId(BsonValue userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<Education> getEducations() {
        return educations;
    }

    public void setEducations(LinkedList<Education> educations) {
        this.educations = educations;
    }

    public LinkedList<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(LinkedList<Experience> experiences) {
        this.experiences = experiences;
    }

}
