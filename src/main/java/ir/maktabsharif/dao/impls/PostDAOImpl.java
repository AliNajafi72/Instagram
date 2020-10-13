package ir.maktabsharif.dao.impls;

import ir.maktabsharif.dao.interfaces.PostDAO;
import ir.maktabsharif.domain.Post;
import ir.maktabsharif.domain.User;
import ir.maktabsharif.util.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PostDAOImpl implements PostDAO {
    @Override
    public Optional<Post> get(long id) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        Optional<Post> postOptional = Optional.of(entityManager.find(Post.class, id));
        return postOptional;
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public void save(Post post) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(post);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(Post post) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(post);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
