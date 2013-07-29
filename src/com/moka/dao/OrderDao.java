package com.moka.dao;

import com.moka.entity.Order;
import com.moka.entity.OrderDetail;

public interface OrderDao {
	// ���濪����Ϣ
	public int saveOrder(Order order);
	
	// ����˱���Ϣ
	public void saveOrderDetail(OrderDetail orderDetail);
	
	// ��������״̬, ����
	public void updateTableStatus(int tableId);
	
	// ��������״̬, ��λ
	public void updateTableStatusEx(int orderId);
}
