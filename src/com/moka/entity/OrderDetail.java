package com.moka.entity;

/**
 *	���ڷ�װOrderDetailTbl���ʵ����
 */
public class OrderDetail {
	// ���
	private int id;
	// ��ϸ�ڵ�����������
	private int orderId;
	// ��Ʒ���
	private int menuId;
	// ����
	private int num;
	// ��ע
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
