package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
=======
import com.inventory.management.entities.Classification;
>>>>>>> 65496a6267815531abea099c6d8f4b1d775780ef
import com.inventory.management.entities.ItemType;
public interface ItemTypeRepo extends CrudRepository<ItemType,Integer>{
	public ItemType findById(int id);

}
