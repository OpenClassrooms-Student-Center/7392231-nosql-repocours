package com.openclassrooms.blogdatalayer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.LightPost;
import com.openclassrooms.blogdatalayer.model.Post;
import com.openclassrooms.blogdatalayer.model.PostAggregate;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	public List<Post> findByName(String name);
	public List<LightPost> findByOrderByDateDesc();
	@Query(value="{}", fields="{_id : 1, name : 1}", sort = "{ date : -1 }")
	public List<Post> findIdAndNameExcludeOthers();
	
	@Aggregation("{ '$project': { '_id' : '$name' } }")
	public List<String> findAllName(); 
	
	@Aggregation("{ $group: { _id : $date, names : { $addToSet : $name } } }")
	public List<PostAggregate> groupByDate();

}

