package com.openclassrooms.blogdatalayer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.Tutorial;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {

}
