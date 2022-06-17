package com.inventory.management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.inventory.management.dao.StockRepo;
import com.inventory.management.entities.Stock;

@Component
public class StockServices implements StockServicesInterface {
	@Autowired
	private StockRepo stockRepo;

	public List<Stock> getAllStock() {
		List<Stock> stock1 = (List<Stock>) this.stockRepo.findAll();
		return stock1;
	}

	public Stock getStockById(int id) {
		Stock stock2 = null;
		stock2 = this.stockRepo.findById(id);
		return stock2;
	}

	public Stock addStock(Stock stock3) {
		this.stockRepo.save(stock3);
		return stock3;
	}

	public void deleteStock(int id) {
		stockRepo.deleteById(id);
	}

	public Stock updateStock(Stock stock3, int id) {
		Stock stock = new Stock();
		stock.setId(stock3.getId());
		stock.setAvailableQty(stock3.getAvailableQty());
		stock.setLocationCode(stock3.getLocationCode());
		this.stockRepo.save(stock);
		return stock;
	}
}
