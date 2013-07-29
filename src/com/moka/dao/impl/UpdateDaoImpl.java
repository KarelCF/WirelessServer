package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moka.dao.UpdateDao;
import com.moka.entity.Menu;
import com.moka.entity.Table;
import com.moka.util.DBUtil;

public class UpdateDaoImpl implements UpdateDao {

	@Override
	public List<Table> getTableList() {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		// ��������������Ϣ׼������
		String sql = "select id, num, flag, description from tabletbl ";
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// �½�list������������ʵ�������
			List<Table> tableList = new ArrayList<Table>(); 
			while (rs.next()) {
				// table Ҫ����whileѭ����ÿ���½�, ����list�н��ʼ�ջ������һ������
				Table table = new Table();
				table.setId(rs.getInt(1));
				table.setNum(rs.getInt(2));
				table.setFlag(rs.getInt(3));
				table.setDescription(rs.getString(4));
				tableList.add(table);
			}
			// �����˷���list
			return tableList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Menu> getMenuList() {
		// jdbc�������ݿ�׼������
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		// �������в�Ʒ��Ϣ׼������
		String sql = "select id, price, typeId, name, pic, remark from menutbl ";
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// �½�list������������ʵ�������
			List<Menu> menulist = new ArrayList<Menu>(); 
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt(1));
				menu.setPrice(rs.getInt(2));
				menu.setTypeId(rs.getInt(3));
				menu.setName(rs.getString(4));
				menu.setPic(rs.getString(5));
				menu.setRemark(rs.getString(6));
				menulist.add(menu);
			}
			// �����˷���list
			return menulist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
