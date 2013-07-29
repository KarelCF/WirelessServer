package com.moka.entity;

/**
 *	用于封装OrderDetailTbl表的实体类
 */
public class OrderDetail {
	// 编号
	private int id;
	// 此细节单的主订单号
	private int orderId;
	// 菜品编号
	private int menuId;
	// 数量
	private int num;
	// 备注
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
