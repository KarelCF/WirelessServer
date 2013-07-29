package com.moka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moka.dao.UserDao;
import com.moka.entity.User;
import com.moka.util.DBUtil;

/**
 * �û���¼DAOʵ����
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * ͨ���û����ƺ������¼����¼�ɹ�����User���󣬵�¼ʧ�ܷ���null
	 */
	public User login(String account, String password) {
		
		// ��ѯSQL���,
		String sql = " select id, account, password, name, gender, permission, remark " +
						"from usertbl " +
						"where account=? and password=? ";
		
		// ʵ�������ݿ����ӹ�����,�������,׼��PreparedStatement�ͽ����
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// ���PreparedStatement
			ps = conn.prepareStatement(sql);
			// ���ò�ѯ����
			ps.setString(1, account);
			ps.setString(2, password);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			// �ж��û��Ƿ����
			if (rs.next()) {
				// ����û���Ϣ(��Ҫϸ��:�˴���ȡ��λ������Ҫ���������sql����е�˳��,����һ�������ݿ��е�˳��)
				int id = rs.getInt(1);
				String name = rs.getString(4);
				int permission = rs.getInt(6);
				String remark = rs.getString(7);
				
				// ��װ�û���Ϣ
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
