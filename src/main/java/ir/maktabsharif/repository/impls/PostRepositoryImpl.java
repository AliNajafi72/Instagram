package ir.maktabsharif.repository.impls;

import ir.maktabsharif.dao.impls.PostDAOImpl;
import ir.maktabsharif.domain.Post;
import ir.maktabsharif.repository.inerfaces.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {
    PostDAOImpl postDAOImpl = new PostDAOImpl();
    @Override
    public Optional<Post> get(long id) {
        Optional<Post> postOptional = postDAOImpl.get(id);
        return postOptional;
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public void save(Post post) {
        postDAOImpl.save(post);
    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(Post post) {
        postDAOImpl.delete(post);
    }

}
