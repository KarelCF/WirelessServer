package com.moka.dao;

import java.util.List;

import com.moka.entity.Menu;
import com.moka.entity.Table;


public interface UpdateDao {
	// ��ò����б�
	public List<Table> getTableList();
	// ��ò˵��б�
	public List<Menu> getMenuList();
}
