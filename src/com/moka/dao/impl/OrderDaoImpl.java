package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moka.dao.OrderDao;
import com.moka.entity.Order;
import com.moka.entity.OrderDetail;
import com.moka.util.DBUtil;


public class OrderDaoImpl implements OrderDao {
	
	@Override
	public int saveOrder(Order order) {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// �������ݿ������
		String saveOrderSql = "insert into ordertbl (orderTime, userId, tableId, personNum) values (?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		// ��ȡ���¶����Ų�����
		Statement statement = null;
		ResultSet orderIdSet = null;
		try {
			ps = conn.prepareStatement(saveOrderSql);
			ps.setString(1, order.getOrderTime());
			ps.setInt(2, order.getUserId());
			ps.setInt(3, order.getTableId());
			ps.setInt(4, order.getPersonNum());
			ps.executeUpdate();
			
			// ���ش˶������,��ΪidΪ��������������ȡ�����Ϊ���¶�����
			String returnOrderIdSql = "select max(id) as id from ordertbl";
			statement = conn.createStatement();
			orderIdSet = statement.executeQuery(returnOrderIdSql);
			if (orderIdSet.next()) {
				// ��ö�����
				int id = orderIdSet.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (orderIdSet != null) {
					orderIdSet.close();
					orderIdSet = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
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
		return 0;
	}
	
	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		// �������ݿ������
		String saveOrderSql = "insert into orderdetailtbl (orderId, menuId, num, remark) values (?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(saveOrderSql);
			ps.setInt(1, orderDetail.getOrderId());
			ps.setInt(2, orderDetail.getMenuId());
			ps.setInt(3, orderDetail.getNum());
			ps.setString(4, orderDetail.getRemark());
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
	
	@Override
	public void updateTableStatus(int tableId) {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// ���´���״̬������
		String updateSql = "update tabletbl set flag = 1 where id = ?";
		PreparedStatement ps = null;
		try {
			// �����Ѷ���, table����flag��λ
			ps = conn.prepareStatement(updateSql);
			ps.setInt(1, tableId);
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
	
	@Override
	public void updateTableStatusEx(int orderId) {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// ���´���״̬������
		String updateSql = "update tabletbl set flag = 0 where id = (select tableId from ordertbl where id = ?)";
		PreparedStatement ps = null;
		try {
			// �����ѽ���, table����flag����
			ps = conn.prepareStatement(updateSql);
			ps.setInt(1, orderId);
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
