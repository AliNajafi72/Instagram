package ir.maktabsharif.repository.impls;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.interfaces.PostRepository;
import ir.maktabsharif.domain.Post;
import ir.maktabsharif.util.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {
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
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(post);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
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

    @Override
    public List<Post> findAllPostsByUserId(long userId) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        User user = entityManager.find(User.class, userId);
        return user.getPosts();
    }

    @Override
    public List<Post> searchPosts(String keyWord) {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManagerFactoryInstance().createEntityManager();
        TypedQuery<Post> query = entityManager.createNamedQuery("POST_GET_ALL_DESC", Post.class);
        query.setParameter("keyword", "%" + keyWord + "%");
        return query.getResultList();
    }
}
