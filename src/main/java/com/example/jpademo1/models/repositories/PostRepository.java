package com.example.jpademo1.models.repositories;

import com.example.jpademo1.models.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
