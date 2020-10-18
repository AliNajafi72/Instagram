package ir.maktabsharif.repository.interfaces;

import ir.maktabsharif.domain.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<Long, User> {
    Optional<User> findUserByUsername(String username);
    void deletePostFromUser(Long userId, Integer postIndex);
}
