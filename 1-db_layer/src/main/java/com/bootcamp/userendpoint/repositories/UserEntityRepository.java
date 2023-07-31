package com.bootcamp.userendpoint.repositories;

import com.bootcamp.userendpoint.model.User;
import com.bootcamp.userendpoint.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
