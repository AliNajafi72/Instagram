package ir.maktabsharif.dao.impls;

import ir.maktabsharif.dao.interfaces.UserDAO;
import ir.maktabsharif.domain.User;
import ir.maktabsharif.util.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public Optional<User> findUserByUsername(String username) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        TypedQuery<User> query = entityManager.createNamedQuery("USER_FIND_BY_ID", User.class);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        Optional<User> userOptional;
        if (users.size() > 0) {
            userOptional = Optional.of(users.get(0));
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.flush();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
