package com.inventory.management.services;

import java.util.List;

import com.inventory.management.entities.Item;

public interface ItemServicesInterface {
	
	public List<Item> getAllItem();
	
	public Item getItemById(int id);
	
	public Item addItem(Item it2);
	
	public Item updateItem(Item it3);
	
	public void deleteItem(int id);
}
