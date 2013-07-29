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
		// jdbc连接数据库准备工作
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		// 读出所有桌号信息准备工作
		String sql = "select id, num, flag, description from tabletbl ";
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// 新建list容纳所有桌号实体类对象
			List<Table> tableList = new ArrayList<Table>(); 
			while (rs.next()) {
				// table 要放在while循环内每次新建, 否则list中结果始终会是最后一个桌号
				Table table = new Table();
				table.setId(rs.getInt(1));
				table.setNum(rs.getInt(2));
				table.setFlag(rs.getInt(3));
				table.setDescription(rs.getString(4));
				tableList.add(table);
			}
			// 别忘了返回list
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
		// jdbc连接数据库准备工作
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		// 读出所有菜品信息准备工作
		String sql = "select id, price, typeId, name, pic, remark from menutbl ";
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// 新建list容纳所有桌号实体类对象
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
			// 别忘了返回list
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
