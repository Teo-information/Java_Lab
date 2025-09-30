package dev.group.hexagonal_test.adapter.persistence_mysql.adapter;

import dev.group.hexagonal_test.adapter.persistence_mysql.entity.UserEntity;
import dev.group.hexagonal_test.adapter.persistence_mysql.repository.UserRepository;
import dev.group.hexagonal_test.domain.model.User;
import dev.group.hexagonal_test.domain.port.UserPersistence;
import dev.group.hexagonal_test.domain.service.UserService;
import jakarta.transaction.Transactional;

import java.util.stream.Stream;

@Transactional
public class UserPersistenceAdapter implements UserPersistence {
    private final UserRepository userRepository;

    public UserPersistenceAdapter (UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public Stream<User> getAll() {
        return userRepository.findAll().stream().map(UserEntity::toDomain);
    }

    @Override
    public User getById(Long aLong) {
        return userRepository.findById(aLong).get().toDomain();
    }

    @Override
    public User save(User instance) {
        return userRepository.save(UserEntity.fromDomain(instance)).toDomain();
    }

    @Override
    public User update(User user) {
        var entity = UserEntity.fromDomain(user);

        return userRepository.save(entity).toDomain();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
