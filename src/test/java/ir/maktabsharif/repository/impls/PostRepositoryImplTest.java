package ir.maktabsharif.repository.impls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    PostRepositoryImpl postRepository = new PostRepositoryImpl();

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
    void findAllPostsByUserId() {
        int rows = postRepository.findAllPostsByUserId(1).size();
        assertEquals(3, rows);
    }

    @Test
    void searchPosts() {
        int rows = postRepository.searchPosts("Java").size();
        assertEquals(3, rows);
    }
}