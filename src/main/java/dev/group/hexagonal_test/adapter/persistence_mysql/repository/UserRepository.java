package dev.group.hexagonal_test.adapter.persistence_mysql.repository;

import dev.group.hexagonal_test.adapter.persistence_mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
