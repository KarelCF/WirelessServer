package com.moka.entity;

/**
 *	用于封装查一个对应订单的明细信息的实体类
 */
public class QueryOrderDetail {
	// 菜名
	private String dishName;
	// 菜价
	private int price;
	// 数量
	private int dishNum;
	// 总价
	private int totalPrice;
	// 备注
	private String remark;
	
	public synchronized String getDishName() {
		return dishName;
	}
	
	public synchronized void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	public synchronized int getPrice() {
		return price;
	}
	
	public synchronized void setPrice(int price) {
		this.price = price;
	}
	
	public synchronized int getDishNum() {
		return dishNum;
	}
	
	public synchronized void setDishNum(int dishNum) {
		this.dishNum = dishNum;
	}
	
	public synchronized int getTotalPrice() {
		return totalPrice;
	}
	
	public synchronized void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public synchronized String getRemark() {
		return remark;
	}
	
	public synchronized void setRemark(String remark) {
		this.remark = remark;
	}
	
}
