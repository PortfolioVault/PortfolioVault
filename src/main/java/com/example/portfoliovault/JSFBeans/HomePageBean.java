package com.example.portfoliovault.JSFBeans;


import com.example.portfoliovault.models.UserSessionBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class HomePageBean implements Serializable {
    @Inject
    private UserSessionBean userSession;
    private String firstName = userSession.getFirstName();
    private String lastName = userSession.getLastName();
    private String email = userSession.getEmail();

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
