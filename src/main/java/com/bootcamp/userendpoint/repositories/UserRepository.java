package com.bootcamp.userendpoint.repositories;

import com.bootcamp.userendpoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
