package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moka.dao.PayDao;
import com.moka.entity.QueryOrder;
import com.moka.entity.QueryOrderDetail;
import com.moka.util.DBUtil;

public class PayDaoImpl implements PayDao {

	@Override
	public QueryOrder getOrderById(int id) {
		
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// �������ݿ�����ã��˴��õ�������,����������֪ʶ
		String queryOrderSql = "select ut.name, ot.orderTime, ot.personNum, ot.tableId from ordertbl ot " +
							  "join usertbl ut on ot.userId = ut.id where ot.id = ?" ;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		// ʵ������װ���ݵ�QueryOrder��
		QueryOrder queryOrder = new QueryOrder();
		try {
			ps = conn.prepareStatement(queryOrderSql);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				// ʹ�������������QueryOrder
				queryOrder.setName(resultSet.getString(1));
				queryOrder.setOrderTime(resultSet.getString(2));
				queryOrder.setPersonNum(resultSet.getInt(3));
				queryOrder.setTableId(resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return queryOrder;
	}

	@Override
	public List getOrderDetailById(int id) {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// �������ݿ�����ã�ʹ��union�ϲ������������ܼ�
		String queryOrderDetailSql = "select mt.name, mt.price, odt.num, mt.price * odt.num totalPrice, odt.remark from orderdetailtbl odt " +
							  "join menutbl mt on odt.menuId = mt.id where odt.orderId = ? " +
							  "union  select '', '', '', sum(mt.price * odt.num) allPrice, '' from orderdetailtbl odt " +
							  "join menutbl mt on odt.menuId = mt.id where odt.orderId = ? "	;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		// ׼�����ص�QueryOrderDetail�б�
		List<QueryOrderDetail> list = new ArrayList<QueryOrderDetail>();
		try {
			ps = conn.prepareStatement(queryOrderDetailSql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				// ʵ������װ���ݵ�QueryOrderDetail��
				QueryOrderDetail queryOrderDetail = new QueryOrderDetail();
				// ʹ�������������QueryOrderDetail
				queryOrderDetail.setDishName(resultSet.getString(1));
				queryOrderDetail.setPrice(resultSet.getInt(2));
				queryOrderDetail.setDishNum(resultSet.getInt(3));
				queryOrderDetail.setTotalPrice(resultSet.getInt(4));
				queryOrderDetail.setRemark(resultSet.getString(5));
				// װ��List
				list.add(queryOrderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void pay(int id) {
		
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// �������ݿ������
		String sql = "update ordertbl set isPay = 1 where id = ?" ;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
