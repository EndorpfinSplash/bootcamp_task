package com.bootcamp.userendpoint.repositories;

import com.bootcamp.userendpoint.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
