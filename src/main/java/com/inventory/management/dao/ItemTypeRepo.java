package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
=======
//
////<<<<<<< HEAD
//=======
import com.inventory.management.entities.Classification;
//>>>>>>> 65496a6267815531abea099c6d8f4b1d775780ef
>>>>>>> 493542dbc4d927b7e58c5ef316ef9ec95cbfd84f
import com.inventory.management.entities.ItemType;

public interface ItemTypeRepo extends CrudRepository<ItemType, Integer> {
	public ItemType findById(int id);

}
