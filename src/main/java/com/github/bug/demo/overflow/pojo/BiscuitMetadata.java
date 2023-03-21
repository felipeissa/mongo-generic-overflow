package com.github.bug.demo.overflow.pojo;

public class BiscuitMetadata {

	private String type;
	private Integer calories;
	
	public BiscuitMetadata(String type, Integer calories) {
		this.type = type;
		this.calories = calories;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCalories() {
		return calories;
	}
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
}
