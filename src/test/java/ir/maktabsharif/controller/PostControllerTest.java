package ir.maktabsharif.controller;

import ir.maktabsharif.domain.Post;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.LongBuffer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {
    PostController postController = new PostController();
    @Test
    void index() {
    }

    @Test
    void addPost() {
    }

    @Test
    void getUserPosts() {
    }

    @Test
    void likePost() {
        String postId = "2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(postId.getBytes());
        System.setIn(inputStream);
        assertEquals(9, postController.likePost());
    }

    @Test
    void addComment() {
    }

    @Test
    void searchPosts() {
        String keyWord = "Java";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(keyWord.getBytes());
        System.setIn(inputStream);
        List<Post> posts = postController.searchPosts();
        assertEquals(3, posts.size());
    }
}