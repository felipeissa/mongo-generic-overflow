package com.github.bug.demo.overflow.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
public class GroceryItem<T> {

	@Id
	private String id;

	private int quantity;
	private GroceryMetadata<T> customData; 

	public GroceryItem(String id, int quantity, GroceryMetadata<T> customData) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.customData = customData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public GroceryMetadata<T> getCustomData() {
		return customData;
	}

	public void setCustomData(GroceryMetadata<T> customData) {
		this.customData = customData;
	}
}