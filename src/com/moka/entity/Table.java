package com.moka.entity;

public class Table {
	// 桌号
	private int id;
	// 数量
	private int num;
	// 是否有人标记
	private int flag;
	// 描述
	private String description;
	
	public synchronized int getId() {
		return id;
	}
	public synchronized void setId(int id) {
		this.id = id;
	}
	public synchronized int getNum() {
		return num;
	}
	public synchronized void setNum(int num) {
		this.num = num;
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
