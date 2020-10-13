package ir.maktabsharif.repository.inerfaces;

import ir.maktabsharif.domain.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<Long, User> {
    Optional<User> findUserByUsername(String username);
}
