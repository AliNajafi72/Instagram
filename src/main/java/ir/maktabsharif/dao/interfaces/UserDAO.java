package ir.maktabsharif.dao.interfaces;

import ir.maktabsharif.domain.User;

import java.util.Optional;

public interface UserDAO extends BaseDAO<Long, User> {
    Optional<User> findUserByUsername(String username);
}
