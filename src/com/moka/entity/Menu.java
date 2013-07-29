package com.moka.entity;

public class Menu {
	private int id;
	private int price;
	private int typeId;
	private String name;
	private String pic;
	private String remark;
	
	public synchronized int getId() {
		return id;
	}
	
	public synchronized void setId(int id) {
		this.id = id;
	}
	
	public synchronized int getPrice() {
		return price;
	}
	
	public synchronized void setPrice(int price) {
		this.price = price;
	}
	
	public synchronized int getTypeId() {
		return typeId;
	}
	
	public synchronized void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized void setName(String name) {
		this.name = name;
	}
	
	public synchronized String getPic() {
		return pic;
	}
	
	public synchronized void setPic(String pic) {
		this.pic = pic;
	}
	
	public synchronized String getRemark() {
		return remark;
	}
	
	public synchronized void setRemark(String remark) {
		this.remark = remark;
	}
	
}
