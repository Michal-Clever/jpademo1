package com.example.jpademo1.models.repositories;

import com.example.jpademo1.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
}
