package repository.inerfaces;

import domain.User;

public interface UserRepository extends BaseRepository<Long, User> {
    User findUserByUsername(String username);
}
