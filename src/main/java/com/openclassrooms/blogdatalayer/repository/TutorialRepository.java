package com.openclassrooms.blogdatalayer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.LightTutorial;
import com.openclassrooms.blogdatalayer.model.Tutorial;
import com.openclassrooms.blogdatalayer.model.TutorialAggregate;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {

	public Optional<Tutorial> findByName(String name);
	
	public List<Tutorial> findByShortDescriptionContains(String value);
	
	public List<LightTutorial> findByOrderByCategoryAsc();
	@Query(value="{}", fields="{_id : 1, name : 1}", sort = "{ date : -1 }")
	public List<Tutorial> findIdAndNameExcludeOthers();
	
	@Aggregation("{ $group: { _id : $category, tutorials : { $addToSet : {'name': '$name', 'shortDescription':'$shortDescription'} } } }")
	public List<TutorialAggregate> groupByCategory();

}
