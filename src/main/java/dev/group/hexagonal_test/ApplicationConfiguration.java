package dev.group.hexagonal_test;

import dev.group.hexagonal_test.adapter.persistence_mysql.adapter.UserPersistenceAdapter;
import dev.group.hexagonal_test.adapter.persistence_mysql.entity.UserEntity;
import dev.group.hexagonal_test.adapter.persistence_mysql.repository.UserRepository;
import dev.group.hexagonal_test.adapter.rest_adapter.controller.WebController;
import dev.group.hexagonal_test.adapter.rest_adapter.exception_handler.WebExceptionHandler;
import dev.group.hexagonal_test.domain.model.User;
import dev.group.hexagonal_test.domain.port.UserPersistence;
import dev.group.hexagonal_test.domain.service.UserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@ComponentScan(basePackageClasses = {WebExceptionHandler.class})
@Configuration
@EntityScan(basePackageClasses = {
        UserEntity.class
})
@EnableJpaRepositories(basePackageClasses = {
        UserRepository.class
})
public class ApplicationConfiguration {
    @Bean
    public UserPersistence userPersistence (UserRepository repository) {
        return new UserPersistenceAdapter(repository);
    }

    @Bean
    public UserService userService (UserPersistence persistence) {
        return new UserService() {
            @Override
            public Stream<User> readAll() {
                return persistence.getAll();
            }

            @Override
            public User create(User user) {
                return persistence.save(user);
            }

            @Override
            public User update(User user) {
                return persistence.save(user);
            }
        };
    }

    @Bean
    public WebController webController (UserService service) {
        return new WebController(service);
    }
}
