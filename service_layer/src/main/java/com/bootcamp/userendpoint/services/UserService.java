package com.bootcamp.userendpoint.services;

import com.bootcamp.userendpoint.model.User;
import com.bootcamp.userendpoint.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Value("${custom.options.user_sorting_order}")
    private String SORT_USER_FIELDS;

    @Value("${custom.options.page_size}")
    private int PAGE_SIZE;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll(PageRequest.of(0, PAGE_SIZE, Sort.by(SORT_USER_FIELDS)));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
