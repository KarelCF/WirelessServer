package com.moka.entity;

/**
 *	���ڷ�װ��һ����Ӧ��������Ϣ��ʵ����
 */
public class QueryOrder {
	// ����Ա����
	private String name;
	// �µ�ʱ��
	private String orderTime;
	// ����
	private int personNum;
	// ����
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
