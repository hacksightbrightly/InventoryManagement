package com.inventory.management.dao;

import com.inventory.management.entities.Classification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepo extends CrudRepository<Classification, Integer> {
	public Classification findById(int id);
}
