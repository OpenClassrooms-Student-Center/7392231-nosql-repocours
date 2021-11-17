package com.openclassrooms.blogdatalayer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.Tutorial;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {

	public Optional<Tutorial> findByName(String name);
	
	public List<Tutorial> findByShortDescriptionContains(String value);

}
