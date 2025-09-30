package dev.group.hexagonal_test.domain.service;

import dev.group.hexagonal_test.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface UserService {
    Stream<User> readAll();
    User create (User user);
    User update (User user);
}
