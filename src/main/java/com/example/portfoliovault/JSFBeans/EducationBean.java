package com.example.portfoliovault.JSFBeans;

import com.example.portfoliovault.models.Education;
import com.example.portfoliovault.models.UserSessionBean;
import com.example.portfoliovault.services.EducationService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class EducationBean  implements Serializable {
    @Size(max = 255)
    private String diplomat;
    @Size(max = 255)
    private String university;
    private String yearOfObtention;


    // Inject the UserService bean
    @Inject
    private EducationService educationService;
    @Inject
    private UserSessionBean userSession;


    public String save() {
        String userId = userSession.getUserId().toString(); // Obtenez la représentation complète de l'ID en tant que chaîne

        // Supprimez la partie "BsonObjectId{value=" du début de la chaîne
        int startIndex = userId.indexOf("value=") + "value=".length();
        int endIndex = userId.length() - 1; // Ignorer le dernier caractère '}'
        String idOnly = userId.substring(startIndex, endIndex);

        //add education to my DB
        educationService.addEducation(idOnly,diplomat, university, yearOfObtention);

        // Créez une nouvelle éducation
        Education newEducation = new Education(diplomat,university, yearOfObtention, idOnly);

        // Ajoutez la nouvelle éducation à la liste des éducations de l'utilisateur
        userSession.setEducations(newEducation);

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        try{
            externalContext.redirect(externalContext.getRequestContextPath() + "/home.xhtml");
        }catch(
                IOException e){
            e.printStackTrace();
        }
        diplomat = "";
        yearOfObtention = "";
        university = "";
        return null;
    }

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
}