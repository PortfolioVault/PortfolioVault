package com.example.portfoliovault.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;

import java.io.Serializable;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private BsonValue userId;

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
}
