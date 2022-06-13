package com.inventory.management.services;

import java.util.List;

import com.inventory.management.entities.Classification;

public interface ClassificationServicesInterface {
	
	public List<Classification> getAllClassification();
	
	public Classification getClassificationById(int id);
	
	public Classification addClassification(Classification clf3);
	
	public void deleteClassification(int id);
	
	public Classification updateClassification(Classification clf3, int id);
}
