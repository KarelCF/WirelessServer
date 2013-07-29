package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moka.dao.UserDao;
import com.moka.entity.User;
import com.moka.util.DBUtil;

/**
 * 用户登录DAO实现类
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * 通过用户名称和密码登录，登录成功返回User对象，登录失败返回null
	 */
	public User login(String account, String password) {
		
		// 查询SQL语句,
		String sql = " select id, account, password, name, gender, permission, remark " +
						"from usertbl " +
						"where account=? and password=? ";
		
		// 实例化数据库连接工具类,获得连接,准备PreparedStatement和结果集
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 获得PreparedStatement
			ps = conn.prepareStatement(sql);
			// 设置查询参数
			ps.setString(1, account);
			ps.setString(2, password);
			// 执行查询
			rs = ps.executeQuery();
			// 判断用户是否存在
			if (rs.next()) {
				// 获得用户信息(重要细节:此处获取的位置数字要依照上面的sql语句中的顺序,而不一定是数据库中的顺序)
				int id = rs.getInt(1);
				String name = rs.getString(4);
				int permission = rs.getInt(6);
				String remark = rs.getString(7);
				
				// 封装用户信息
				User user = new User();
				user.setId(id);
				user.setAccount(account);
				user.setPassword(password);
				user.setName(name);
				user.setPermission(permission);
				user.setRemark(remark);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (ps != null) {
					ps.close();
					ps = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			util.closeConn(conn);
		}
		return null;
	}
	
}
