package se.iths.yunus.jakartaee.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.yunus.jakartaee.model.AppUser;
import se.iths.yunus.jakartaee.service.AppUserService;

@Named
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    @Inject
    private AppUserService appUserService;

    @Inject
    private AppUserSessionBean appUserSessionBean;

    public String login() {
        AppUser user = appUserService.login(username, password);

        if (user != null) {
            appUserSessionBean.setLoggedInUser(user);
            return "chat.xhtml?faces-redirect=true";
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Fel användarnamn eller lösenord", null));

        return null;
    }

    public String logout() {
        appUserSessionBean.logout();
        return "login.xhtml?faces-redirect=true";
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