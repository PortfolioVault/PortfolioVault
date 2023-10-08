package com.example.portfoliovault.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
    private LinkedList<Experience> experiences;

    private LinkedList<Education> educations = new LinkedList<>(); // Utilisation d'un Set pour stocker des éducations uniques.

    public LinkedList<Education> getEducations() {
        return educations;
    }

    public void setEducations(Education education) {
        educations.add(education);

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

}
