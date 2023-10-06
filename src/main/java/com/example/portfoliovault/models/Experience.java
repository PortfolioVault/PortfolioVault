package com.example.portfoliovault.models;

public class Experience {
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
}
