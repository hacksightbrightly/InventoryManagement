package com.inventory.management.services;

import java.util.List;

import com.inventory.management.entities.ItemDetails;

public interface ItemDetailsServicesInterface {
	
	public List<ItemDetails> getAllItemDetails();
	
	public ItemDetails getItemDetailsById(int id);
	
	public ItemDetails addItemDetails(ItemDetails itd3);
	
	public void deleteItemDetails(int id);
	
	public ItemDetails updateItemDetails(ItemDetails itd3, int id);
}
