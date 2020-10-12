package repository.inerfaces;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID, T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
