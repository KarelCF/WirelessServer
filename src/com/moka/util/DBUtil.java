package com.moka.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	数据库工具类
 */
public class DBUtil {
	

	/*
	 * 打开数据库连接
	 */
	public Connection openConnection() {
		Properties prop = new Properties();
		String driver = null;
		String url = null;
		String username = null;
		String password = null;

		try {
			// 将properties文件载入Properties类实例
			prop.load(this.getClass().getClassLoader().getResourceAsStream(
					"DBConfig.properties"));

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			// 下句便相当于普通情况下使用jdbc的Class.forName("com.mysql.jdbc.Driver");
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
	 * 关闭数据库连接
	 */
	public void closeConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}