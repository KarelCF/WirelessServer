package com.moka.entity;

public class Table {
	// ����
	private int id;
	// ����
	private int num;
	// �Ƿ����˱��
	private int flag;
	// ����
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
