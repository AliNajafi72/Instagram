package repository.impls;

import domain.Post;
import repository.inerfaces.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {
    @Override
    public Optional<Post> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(Post post) {

    }
}
