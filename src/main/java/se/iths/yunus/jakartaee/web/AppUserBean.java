package se.iths.yunus.jakartaee.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.yunus.jakartaee.model.AppUser;
import se.iths.yunus.jakartaee.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AppUserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private AppUserService appUserService;

    private String username;
    private String password;

    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllUsers();
    }

    public void saveAppUser() {
        appUserService.save(new AppUser(username, password));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
