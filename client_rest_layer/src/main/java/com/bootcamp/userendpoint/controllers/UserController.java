package com.bootcamp.userendpoint.controllers;

import com.bootcamp.userendpoint.exceptions.InvalidEmailAddressException;
import com.bootcamp.userendpoint.exceptions.RoleNotFoundException;
import com.bootcamp.userendpoint.model.Role;
import com.bootcamp.userendpoint.model.User;
import com.bootcamp.userendpoint.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;
import java.util.stream.Stream;

@RestController
public class UserController {

    @Value("${custom.options.user_sorting_order}")
    private String SORT_USER_FIELDS;

    @Value("${custom.options.page_size}")
    private int PAGE_SIZE;

    String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern EMAIL_MATCHER = Pattern.compile(EMAIL_PATTERN);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(
            @RequestBody User user
    ) {

        String email = user.getEmail();
        if (!EMAIL_MATCHER.matcher(email).matches()) {
            throw new InvalidEmailAddressException();
        }

        String role = user.getRole();
        if (Stream.of(Role.values()).noneMatch(r -> r.getRole().equals(role))) {
            throw new RoleNotFoundException();
        }

        User savedUser = userService.saveUser(user);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(savedUser);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {

        return userService.getAllUsers(PageRequest.of(0, PAGE_SIZE, Sort.by(SORT_USER_FIELDS)));
//        return userService.getAllUsers();

    }

}
