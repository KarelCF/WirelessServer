package com.moka.dao;

import com.moka.entity.User;

// UesrDao接口
public interface UserDao {
	// 登录方法
	public User login(String account,String password);
}
