package se.iths.yunus.jakartaee.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import se.iths.yunus.jakartaee.model.AppUser;

import java.io.Serializable;

@Named
@SessionScoped
public class AppUserSessionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AppUser loggedInUser;

    public AppUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(AppUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public void logout() {
        loggedInUser = null;
    }
}