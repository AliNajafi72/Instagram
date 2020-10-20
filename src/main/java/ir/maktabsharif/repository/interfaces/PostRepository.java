package ir.maktabsharif.repository.interfaces;

import ir.maktabsharif.domain.Post;

import java.util.List;

public interface PostRepository extends BaseRepository<Long, Post> {
    List<Post> findAllPostsByUserId(long userId);
    List<Post> searchPosts(String keyWord);
}
