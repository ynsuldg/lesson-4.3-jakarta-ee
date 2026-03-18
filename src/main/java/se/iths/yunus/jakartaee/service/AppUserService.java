package se.iths.yunus.jakartaee.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.yunus.jakartaee.model.AppUser;
import se.iths.yunus.jakartaee.repository.AppUserRepository;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class AppUserService {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class.getName());

    @Inject
    private AppUserRepository appUserRepository;

    public AppUserService() {
    }

    @Transactional
    public AppUser save(AppUser user) {
        LOGGER.info("Saving user: " + user.getUsername());
        return appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers() {
        LOGGER.info("Fetching all users");
        return appUserRepository.findAll();
    }

    public AppUser login(String username, String password) {
        LOGGER.info("Login attempt for username: " + username);

        AppUser user = appUserRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            LOGGER.info("Login successful for username: " + username);
        } else {
            LOGGER.warning("Login failed for username: " + username);
        }

        return user;
    }
}