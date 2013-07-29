package com.moka.dao;

import java.util.List;

import com.moka.entity.QueryOrder;
import com.moka.entity.QueryOrderDetail;

public interface PayDao {
	// 取得主订单信息
	public QueryOrder getOrderById(int id);
	
	// 取得详细订单信息
	public List<QueryOrderDetail> getOrderDetailById(int id);
	
	// 结算操作
	public void pay(int id);
}
