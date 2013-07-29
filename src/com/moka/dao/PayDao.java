package com.moka.dao;

import java.util.List;

import com.moka.entity.QueryOrder;
import com.moka.entity.QueryOrderDetail;

public interface PayDao {
	// ȡ����������Ϣ
	public QueryOrder getOrderById(int id);
	
	// ȡ����ϸ������Ϣ
	public List<QueryOrderDetail> getOrderDetailById(int id);
	
	// �������
	public void pay(int id);
}
