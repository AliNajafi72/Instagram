package dao.interfaces;

import domain.User;

public interface UserDAO extends BaseDAO<Long, User> {
    User findUserByUsername(String username);
}
