package com.inventory.management.services;

import java.util.List;

import com.inventory.management.entities.Stock;

public interface StockServicesInterface {
	
	public List<Stock> getAllStock();

	public Stock getStockById(int id);

	public Stock addStock(Stock stock3);

	public void deleteStock(int id);
	
	public Stock updateStock(Stock stock3, int id);
}
