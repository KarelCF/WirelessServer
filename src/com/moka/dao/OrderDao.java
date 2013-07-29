package com.moka.dao;

import com.moka.entity.Order;
import com.moka.entity.OrderDetail;

public interface OrderDao {
	// 保存开桌信息
	public int saveOrder(Order order);
	
	// 保存菜表信息
	public void saveOrderDetail(OrderDetail orderDetail);
	
	// 更新桌号状态, 有人
	public void updateTableStatus(int tableId);
	
	// 更新桌号状态, 空位
	public void updateTableStatusEx(int orderId);
}
