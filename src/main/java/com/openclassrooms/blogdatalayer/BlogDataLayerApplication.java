package com.openclassrooms.blogdatalayer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.blogdatalayer.model.Tag;
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
		// Add one tutorial
		Tutorial newTutorial = new Tutorial();
		newTutorial.setName("How to create a Spring Boot application");
		newTutorial.setShortDescription("I will explain you how to use Spring Boot to build Java application.");
		newTutorial.setContent("Here we are, Spring Boot is a fantastic module of Spring Framework. It allows auto configuration....");
		newTutorial.setCategory("Spring Boot");
		
		tutorialRepository.insert(newTutorial);
		
		// Add few tutorials
		Tutorial newTuto1 = new Tutorial();
		newTuto1.setName("Deploy a Spring Boot app with Docker");
		newTuto1.setShortDescription("...");
		newTuto1.setContent("...");
		newTuto1.setCategory("Spring Boot");
		
		Tutorial newTuto2 = new Tutorial();
		newTuto2.setName("Build a microservice architecture with Spring Cloud");
		newTuto2.setShortDescription("...");
		newTuto2.setContent("...");
		newTuto2.setCategory("Spring Cloud");
		
		tutorialRepository.insert(List.of(newTuto1, newTuto2));
		
		// Add a tutorial with a Tag
		Tag springTag = new Tag();
		springTag.setName("Spring Framework");
		springTag.setSlug("spring-framework");
		springTag.setDescription("Spring is the most Java framework used on the world.");
		
		Tutorial newTuto3 = new Tutorial();
		newTuto3.setName("How Spring implements the dependency injection pattern");
		newTuto3.setShortDescription("...");
		newTuto3.setContent("...");
		newTuto3.setCategory("Spring");
		newTuto3.setTag(springTag);
		
		tutorialRepository.insert(newTuto3);
	}

}
