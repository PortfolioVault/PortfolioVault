package com.example.portfoliovault.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.bson.BsonValue;

import java.io.Serializable;
import java.util.LinkedList;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String age;
    private String professionalTitle;
    private BsonValue userId;
    private LinkedList<Education> educations = new LinkedList<>(); // Utilisation d'un Set pour stocker des éducations uniques.

    private LinkedList<Experience> experiences;

    public void setEducations(Education education) {
        educations.add(education);

    }

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
