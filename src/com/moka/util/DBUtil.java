package com.moka.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	���ݿ⹤����
 */
public class DBUtil {
	

	/*
	 * �����ݿ�����
	 */
	public Connection openConnection() {
		Properties prop = new Properties();
		String driver = null;
		String url = null;
		String username = null;
		String password = null;

		try {
			// ��properties�ļ�����Properties��ʵ��
			prop.load(this.getClass().getClassLoader().getResourceAsStream(
					"DBConfig.properties"));

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			// �¾���൱����ͨ�����ʹ��jdbc��Class.forName("com.mysql.jdbc.Driver");
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 * �ر����ݿ�����
	 */
	public void closeConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}