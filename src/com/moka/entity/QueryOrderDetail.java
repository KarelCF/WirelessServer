package com.moka.entity;

/**
 *	���ڷ�װ��һ����Ӧ��������ϸ��Ϣ��ʵ����
 */
public class QueryOrderDetail {
	// ����
	private String dishName;
	// �˼�
	private int price;
	// ����
	private int dishNum;
	// �ܼ�
	private int totalPrice;
	// ��ע
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
