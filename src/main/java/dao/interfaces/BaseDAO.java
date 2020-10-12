package dao.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

interface BaseDAO<ID, T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
