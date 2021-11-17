package com.openclassrooms.blogdatalayer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

import com.openclassrooms.blogdatalayer.model.Post;
import com.openclassrooms.blogdatalayer.model.Tutorial;
import com.openclassrooms.blogdatalayer.repository.PostRepository;
import com.openclassrooms.blogdatalayer.repository.TutorialRepository;

@SpringBootApplication
public class BlogDataLayerApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(BlogDataLayerApplication.class);
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogDataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Post> p = postRepository.findById("6177a39b665edf352cf74f90");
		if (p.isPresent()) {
			logger.info(p.get().getContent());
		} else {
			logger.info("Post not found");
		}
		
		Optional<Tutorial> t = tutorialRepository.findById("6192c22d783f4a2a0a7d9bf3");
		if(t.isPresent()) {
			logger.info(t.get().getContent());
		} else {
			logger.info("Tutorial not found");
		}
		
		List<Post> allPosts = postRepository.findAll();
		allPosts.stream().forEach((post) -> logger.info(post.getName()));
		
		List<Tutorial> allTutorials = tutorialRepository.findAll();
		allTutorials.stream().forEach((tutorial) -> logger.info(tutorial.getName()));
		
		Post p1 = new Post();
		p1.setName("Welcome here !");
		Example<Post> example = Example.of(p1); 
		
		p = postRepository.findOne(example);
		
		if (p.isPresent()) {
			logger.info(p.get().getContent());
		} else {
			logger.info("Post not found");
		}
		
		List<Post> result = postRepository.findByName("Welcome here !");
		result.stream().forEach((post) -> logger.info(post.getName()));
		
		Optional<Tutorial> tutorial  = tutorialRepository.findByName("How to use MongoRepository");
		logger.info(tutorial.get().getContent());
		
		List<Tutorial> tutorials = tutorialRepository.findByShortDescriptionContains("tutorial");
		tutorials.stream().forEach((tuto) -> logger.info(tuto.getShortDescription()));
	}

}
