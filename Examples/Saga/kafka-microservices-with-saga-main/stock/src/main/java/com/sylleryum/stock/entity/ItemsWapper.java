package com.sylleryum.stock.entity;

import java.util.List;

public class ItemsWapper {

	private List<StockItem> items;

	public ItemsWapper(List<StockItem> items) {
		super();
		this.items = items;
	}

	public List<StockItem> getItems() {
		return items;
	}

	public void setItems(List<StockItem> items) {
		this.items = items;
	}

}
