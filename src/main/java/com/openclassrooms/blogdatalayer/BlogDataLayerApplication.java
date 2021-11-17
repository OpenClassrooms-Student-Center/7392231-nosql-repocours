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

import com.openclassrooms.blogdatalayer.model.LightPost;
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
		List<LightPost> allPosts = postRepository.findByOrderByDateDesc();
		allPosts.stream().forEach((post) -> logger.info(post.getName()));
		
		List<Post> posts = postRepository.findIdAndNameExcludeOthers();
		posts.stream().forEach((p) -> logger.info(p.getName()));
	}

}
