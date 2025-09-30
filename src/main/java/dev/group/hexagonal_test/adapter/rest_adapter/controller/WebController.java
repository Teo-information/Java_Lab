package dev.group.hexagonal_test.adapter.rest_adapter.controller;

import dev.group.hexagonal_test.domain.model.User;
import dev.group.hexagonal_test.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "*"
})
@RestController
@RequestMapping("/api/v1/web")
public class WebController {
    private UserService service;

    public WebController (UserService userService) {
        this.service = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers () {
        return service.readAll().toList();
    }

    @PostMapping("/users")
    public ResponseEntity<User> create (@RequestBody(required = true) User user) {
        System.out.println(user);
        var e = service.create(user);
        var re = new ResponseEntity<User>(e, HttpStatus.OK);
        return re;
    }
}
