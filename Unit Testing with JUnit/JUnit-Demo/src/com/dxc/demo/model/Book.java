package com.dxc.demo.model;

public class Book {

	private String title = "";
	
	public Book(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void upperCaseTitle() {
		title = title.toUpperCase();
	}
}
