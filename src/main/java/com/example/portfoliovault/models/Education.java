package com.example.portfoliovault.models;

public class Education {
    private String diplomat;
    private String university;
    private String yearOfObtention;

    public String getDiplomat() {
        return diplomat;
    }

    public void setDiplomat(String diplomat) {
        this.diplomat = diplomat;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getYearOfObtention() {
        return yearOfObtention;
    }

    public void setYearOfObtention(String yearOfObtention) {
        this.yearOfObtention = yearOfObtention;
    }

    public Education(String diplomat, String university, String yearOfObtention) {
        this.diplomat = diplomat;
        this.university = university;
        this.yearOfObtention = yearOfObtention;
    }
}
