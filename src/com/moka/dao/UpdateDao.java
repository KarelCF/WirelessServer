package com.moka.dao;

import java.util.List;

import com.moka.entity.Menu;
import com.moka.entity.Table;


public interface UpdateDao {
	// 获得餐桌列表
	public List<Table> getTableList();
	// 获得菜单列表
	public List<Menu> getMenuList();
}
