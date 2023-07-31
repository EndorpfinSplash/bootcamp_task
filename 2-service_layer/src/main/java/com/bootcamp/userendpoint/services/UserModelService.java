package com.bootcamp.userendpoint.services;

import com.bootcamp.userendpoint.UserModelMapper;
import com.bootcamp.userendpoint.model.UserModel;
import com.bootcamp.userendpoint.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class UserModelService {

    private final UserEntityRepository userEntityRepository;
    @Autowired
    private UserModelMapper userModelMapper;


    public UserModelService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public Iterable<UserModel> getAllUsers() {
        return userModelMapper.toModelList(userEntityRepository.findAll());
    }
    public Iterable<UserModel> getAllUsers(PageRequest of) {
        return userModelMapper.toModelList(userEntityRepository.findAll());
    }


    public UserModel saveUser(UserModel userModel) {
        return userModelMapper.toModel(
                userEntityRepository.save(userModelMapper.toEntity(userModel))
        );
    }
}
