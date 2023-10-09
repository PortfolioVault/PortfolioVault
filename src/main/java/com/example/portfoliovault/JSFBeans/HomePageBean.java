package com.example.portfoliovault.JSFBeans;


import com.example.portfoliovault.models.MongoDBConnectionManager;
import com.example.portfoliovault.models.UserSessionBean;
import com.example.portfoliovault.services.UserService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.bson.Document;

import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class HomePageBean implements Serializable {
    @Inject
    private UserSessionBean userSession;
    @Inject
    private UserService userService;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String age;
    private String professionalTitle;

    @PostConstruct
    public void init() {
        // Initialize properties using values from UserSessionBean
        firstName = userSession.getFirstName();
        lastName = userSession.getLastName();
        email = userSession.getEmail();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public void savePersonalInfos(){
        userSession.setProfessionalTitle(professionalTitle);
        userSession.setAddress(address);
        userSession.setPhoneNumber(phoneNumber);
        userSession.setAge(age);
        userService.savePersonalInfos(userSession.getUserId(), phoneNumber,age,professionalTitle,address);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Success!", "Details Saved successfully");
        context.addMessage(null, message);
    }
}
