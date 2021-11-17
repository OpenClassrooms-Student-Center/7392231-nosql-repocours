package com.openclassrooms.blogdatalayer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}

}
