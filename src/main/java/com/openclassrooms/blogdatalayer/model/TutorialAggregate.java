package com.openclassrooms.blogdatalayer.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class TutorialAggregate {
	private @Id String category;
	private List<TutorialExtract> tutorials;
	
	public String getCategory() {
		return category;
	}
	
	public List<TutorialExtract> getTutorials() {
		return tutorials;
	}
}
