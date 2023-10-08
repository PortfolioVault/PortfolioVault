package com.example.portfoliovault.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.bson.Document;

import java.io.Serializable;

public class Experience implements Serializable {
    private String startDate;
    private String endDate;
    private String company;
    private String role;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Experience(String startDate, String endDate, String company, String role) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.role = role;
    }
    public Document toDocument() {
        Document document = new Document();
        document.append("startDate", this.startDate);
        document.append("endDate", this.endDate);
        document.append("company", this.company);
        document.append("role", this.role);
        return document;
    }
}
