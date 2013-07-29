package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moka.dao.CheckDao;
import com.moka.entity.CheckedTable;
import com.moka.util.DBUtil;

public class CheckDaoImpl implements CheckDao {

	@Override
	public List<CheckedTable> getTableList() {
		
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		String sql = "select id, flag, description from tabletbl";
		
		Statement statement = null;
		ResultSet rs = null;
		
		List<CheckedTable> list = new ArrayList<CheckedTable>();
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				CheckedTable ct = new CheckedTable();
				ct.setId(rs.getInt(1));
				ct.setFlag(rs.getInt(2));
				ct.setDescription(rs.getString(3));
				list.add(ct);
			}
			return list;
			
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
		return list;
	}

}
