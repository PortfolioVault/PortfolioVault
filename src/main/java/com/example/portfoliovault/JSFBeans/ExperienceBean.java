package com.example.portfoliovault.JSFBeans;

import com.example.portfoliovault.models.Experience;
import com.example.portfoliovault.models.UserSessionBean;
import com.example.portfoliovault.services.ExperienceService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.LinkedList;

@Named
@SessionScoped
public class ExperienceBean implements Serializable {
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

    @Inject
    private UserSessionBean userSession;
    @Inject
    private ExperienceService experienceService;

    private Experience experience;

    public String ajouterExperience() {
        experience=new Experience(startDate,endDate,company,role);
        LinkedList<Experience> experiences = userSession.getExperiences();
        if (experiences == null) {
            // Si experiences est null, initialiser une nouvelle liste
            experiences = new LinkedList<>();
            userSession.setExperiences(experiences);
        }
        //ajouter les données dans la database
        experienceService.addExperience(userSession.getUserId(), experiences);
        //ajouter les données de la session
        experiences.add(experience);
        //redirection
        return "home";
    }


}
