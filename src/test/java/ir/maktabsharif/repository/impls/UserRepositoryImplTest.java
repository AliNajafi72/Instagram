package ir.maktabsharif.repository.impls;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.util.EntityManagerFactorySingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
    }

    @AfterEach
    void tearDown() {
        entityManager.close();
    }

    @Test
    void findUserByUsername() {

    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deletePostFromUser() {

    }

    @Test
    void searchUser() {
        int rows = userRepository.searchUser("Ali").size();
        assertEquals(2, rows);
    }
}