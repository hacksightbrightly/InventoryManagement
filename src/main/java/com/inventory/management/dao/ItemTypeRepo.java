package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventory.management.entities.ItemType;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepo extends CrudRepository<ItemType, Integer> {
	public ItemType findById(int id);

}
