package com.example.portfoliovault.JSFBeans;
import com.example.portfoliovault.models.UserSessionBean;
import com.example.portfoliovault.services.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.bson.BsonValue;

import java.io.Serializable;


@Named
@SessionScoped
public class SignupBean implements Serializable {
    private static final long serialVersionUID = 2729758432756108274L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Inject the UserService bean
    @Inject
    private UserService userService;
    @Inject
    private UserSessionBean userSession;

    public String signup() {

        BsonValue userId = userService.registerUser(firstName, lastName, email, password);
        userSession.setUserId(userId.toString());
        userSession.setEmail(email);
        userSession.setFirstName(firstName);
        userSession.setLastName(lastName);
        return "home"; // Specify the navigation outcome to a success page
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
