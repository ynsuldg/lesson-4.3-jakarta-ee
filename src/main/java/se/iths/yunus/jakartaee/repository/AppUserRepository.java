package se.iths.yunus.jakartaee.repository;

import se.iths.yunus.jakartaee.model.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser save(AppUser user);

    List<AppUser> findAll();

    AppUser findByUsernameAndPassword(String username, String password);
}
