package com.bootcamp.userendpoint.controllers;

import com.bootcamp.userendpoint.exceptions.InvalidEmailAddressException;
import com.bootcamp.userendpoint.exceptions.RoleNotFoundException;
import com.bootcamp.userendpoint.model.Role;
import com.bootcamp.userendpoint.services.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserDtoController {

    @Value("${custom.options.user_sorting_order}")
    private String SORT_USER_FIELDS;

    @Value("${custom.options.page_size}")
    private int PAGE_SIZE;

    String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern EMAIL_MATCHER = Pattern.compile(EMAIL_PATTERN);
    private final UserModelService userModelService;
    @Autowired
    private UserDtoMapper userDtoMapper;

    public UserDtoController(UserModelService userService) {
        this.userModelService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> saveUser(
            @RequestBody UserDto userDto
    ) {

        String email = userDto.getEmail();
        if (!EMAIL_MATCHER.matcher(email).matches()) {
            throw new InvalidEmailAddressException();
        }

        String role = userDto.getRole();
        if (Stream.of(Role.values()).noneMatch(r -> r.getRole().toLowerCase().equals(role.toLowerCase()))) {
            throw new RoleNotFoundException();
        }

        UserDto savedUser = userDtoMapper.toDto(userModelService.saveUser(userDtoMapper.toModel(userDto)));

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(savedUser);
    }

    @GetMapping("/users")
    public Iterable<UserDto> getAllUsers() {
        return userDtoMapper.toDtoList(userModelService.getAllUsers(PageRequest.of(0, PAGE_SIZE, Sort.by(SORT_USER_FIELDS))));
    }

}
