package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;
import com.inventory.management.entities.ItemDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemDetailsRepo extends CrudRepository<ItemDetails, Integer> {
	public ItemDetails findById(int id);
}
