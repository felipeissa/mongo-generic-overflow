package com.github.bug.demo.overflow.pojo;

public class GroceryMetadata<T> {
	
	public GroceryMetadata(T data) {
		this.data = data;
	}

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
