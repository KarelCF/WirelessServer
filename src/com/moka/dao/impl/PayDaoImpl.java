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
		
		// jdbc连接数据库准备工作
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// 插入数据库操作用，此处用到表连接,表重命名的知识
		String queryOrderSql = "select ut.name, ot.orderTime, ot.personNum, ot.tableId from ordertbl ot " +
							  "join usertbl ut on ot.userId = ut.id where ot.id = ?" ;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		// 实例化封装数据的QueryOrder类
		QueryOrder queryOrder = new QueryOrder();
		try {
			ps = conn.prepareStatement(queryOrderSql);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				// 使用所获数据填充QueryOrder
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
		// jdbc连接数据库准备工作
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// 插入数据库操作用，使用union合并最后单算出来的总价
		String queryOrderDetailSql = "select mt.name, mt.price, odt.num, mt.price * odt.num totalPrice, odt.remark from orderdetailtbl odt " +
							  "join menutbl mt on odt.menuId = mt.id where odt.orderId = ? " +
							  "union  select '', '', '', sum(mt.price * odt.num) allPrice, '' from orderdetailtbl odt " +
							  "join menutbl mt on odt.menuId = mt.id where odt.orderId = ? "	;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		// 准备传回的QueryOrderDetail列表
		List<QueryOrderDetail> list = new ArrayList<QueryOrderDetail>();
		try {
			ps = conn.prepareStatement(queryOrderDetailSql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				// 实例化封装数据的QueryOrderDetail类
				QueryOrderDetail queryOrderDetail = new QueryOrderDetail();
				// 使用所获数据填充QueryOrderDetail
				queryOrderDetail.setDishName(resultSet.getString(1));
				queryOrderDetail.setPrice(resultSet.getInt(2));
				queryOrderDetail.setDishNum(resultSet.getInt(3));
				queryOrderDetail.setTotalPrice(resultSet.getInt(4));
				queryOrderDetail.setRemark(resultSet.getString(5));
				// 装入List
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
		
		// jdbc连接数据库准备工作
		DBUtil util = new DBUtil(); 
		Connection conn = util.openConnection();
		
		// 更新数据库操作用
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
