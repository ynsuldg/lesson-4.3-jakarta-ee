package se.iths.yunus.jakartaee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import se.iths.yunus.jakartaee.model.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserJpaRepository implements AppUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AppUser save(AppUser user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<AppUser> findAll() {
        return em.createQuery("SELECT m FROM AppUser m", AppUser.class).getResultList();
    }

    @Override
    public AppUser findByUsernameAndPassword(String username, String password) {
        try {
            return em.createQuery(
                            "SELECT u FROM AppUser u WHERE u.username = :username AND u.password = :password",
                            AppUser.class
                    )
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}