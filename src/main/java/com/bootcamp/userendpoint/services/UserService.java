package com.bootcamp.userendpoint.services;

import com.bootcamp.userendpoint.model.User;
import com.bootcamp.userendpoint.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll(Sort.by("email"));
    }

    public void saveUser(String surname,
                         String name,
                         String patronymic,
                         String email,
                         String role) {
        userRepository.save(new User(surname, name, patronymic, email, role));
    }
}
