package com.openclassrooms.blogdatalayer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}

