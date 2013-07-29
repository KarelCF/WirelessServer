package com.moka.entity;

public class CheckedTable {
	private int id;
	private int flag;
	private String description;
	
	public synchronized int getId() {
		return id;
	}
	
	public synchronized void setId(int id) {
		this.id = id;
	}
	
	public synchronized int getFlag() {
		return flag;
	}
	
	public synchronized void setFlag(int flag) {
		this.flag = flag;
	}
	
	public synchronized String getDescription() {
		return description;
	}
	
	public synchronized void setDescription(String description) {
		this.description = description;
	}
	
}
