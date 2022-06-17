package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventory.management.entities.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer> {
	public Item findById(int id);
}
