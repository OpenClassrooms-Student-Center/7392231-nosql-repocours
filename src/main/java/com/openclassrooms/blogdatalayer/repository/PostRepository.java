package com.openclassrooms.blogdatalayer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.blogdatalayer.model.LightPost;
import com.openclassrooms.blogdatalayer.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	public List<Post> findByName(String name);
	public List<LightPost> findByOrderByDateDesc();
	@Query(value="{}", fields="{_id : 1, name : 1}", sort = "{ date : -1 }")
	public List<Post> findIdAndNameExcludeOthers();
}

