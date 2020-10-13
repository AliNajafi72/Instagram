package ir.maktabsharif.repository.impls;

import ir.maktabsharif.dao.impls.UserDAOImpl;
import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.inerfaces.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    UserDAOImpl userDAOImpl = new UserDAOImpl();
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userDAOImpl.findUserByUsername(username);
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
        userDAOImpl.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
