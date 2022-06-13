package com.inventory.management.services;

import java.util.List;

import com.inventory.management.entities.ItemType;

public interface ItemTypeServicesInterface {
	
	public List<ItemType> getAllItemType();

	public ItemType getItemTypeById(int id);

	public ItemType addItemType(ItemType it2);

	public ItemType updateItemType(ItemType it3);

	public void deleteItemType(int id);
}
