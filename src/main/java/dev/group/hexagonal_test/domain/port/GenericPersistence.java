package dev.group.hexagonal_test.domain.port;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface GenericPersistence<T, ID> {
    Stream<T> getAll();
    T getById(ID id);
    T save (T instance);
    T update (T instance);
    void deleteById(ID id);
}
