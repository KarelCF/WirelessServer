package com.moka.dao;

import com.moka.entity.User;

// UesrDao�ӿ�
public interface UserDao {
	// ��¼����
	public User login(String account,String password);
}
