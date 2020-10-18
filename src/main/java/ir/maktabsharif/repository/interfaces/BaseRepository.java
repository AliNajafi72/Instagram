package ir.maktabsharif.repository.interfaces;

import java.util.List;
import java.util.Optional;

interface BaseRepository<ID, T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
