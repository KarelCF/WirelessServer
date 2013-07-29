package com.moka.entity;

/**
 *	用于封装查一个对应订单的信息的实体类
 */
public class QueryOrder {
	// 服务员名字
	private String name;
	// 下单时间
	private String orderTime;
	// 人数
	private int personNum;
	// 桌号
	private int tableId;
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized void setName(String name) {
		this.name = name;
	}
	
	public synchronized String getOrderTime() {
		return orderTime;
	}
	
	public synchronized void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public synchronized int getPersonNum() {
		return personNum;
	}
	
	public synchronized void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	
	public synchronized int getTableId() {
		return tableId;
	}
	
	public synchronized void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
}
