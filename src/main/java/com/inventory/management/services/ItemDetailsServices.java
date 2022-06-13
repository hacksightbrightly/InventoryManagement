package com.inventory.management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.inventory.management.dao.ItemDetailsRepo;
import com.inventory.management.entities.ItemDetails;

@Component
public class ItemDetailsServices {
	@Autowired
	private ItemDetailsRepo itdRepo;

	public List<ItemDetails> getAllItemDetails() {
		List<ItemDetails> itd1 = (List<ItemDetails>) this.itdRepo.findAll();
		return itd1;
	}

	public ItemDetails getItemDetailsById(int id) {
		ItemDetails itd2 = null;
		try {
			itd2 = this.itdRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itd2;
	}

	public ItemDetails addItemDetails(ItemDetails itd3) {
		this.itdRepo.save(itd3);
		return itd3;
	}

	public void deleteItemDetails(int id) {
		itdRepo.deleteById(id);
	}

	public ItemDetails updateItemDetails(ItemDetails itd3, int id) {
		ItemDetails itd = new ItemDetails();
		itd.setId(itd3.getId());
		itd.setName(itd3.getName());
		itd.setDescription(itd3.getDescription());
		itd.setMedia(itd3.getMedia());
		this.itdRepo.save(itd);
		return itd;
	}
}
