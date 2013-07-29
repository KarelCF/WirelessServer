package com.moka.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.UpdateDao;
import com.moka.dao.impl.UpdateDaoImpl;
import com.moka.entity.Menu;

public class UpdateMenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// 获取所有菜单信息列表
		UpdateDao updateDao = new UpdateDaoImpl();
		List<Menu> menuList = updateDao.getMenuList();
		
		// 将所有信息以xml格式输出, 此处设定编码为gbk, 否则中文乱码
		pw.println("<?xml version='1.0' encoding='gbk'?>");
		pw.println("<menulist>");
				
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			pw.println("<menu>");
			
				pw.print("<id>");
					pw.print(menu.getId());
				pw.print("</id>");
				
				pw.print("<price>");
					pw.print(menu.getPrice());
				pw.print("</price>");
				
				pw.print("<typeId>");
					pw.print(menu.getTypeId());
				pw.print("</typeId>");
				
				pw.print("<name>");
					pw.print(menu.getName());
				pw.print("</name>");
				
				pw.print("<pic>");
					pw.print(menu.getPic());
				pw.print("</pic>");
				
				pw.print("<remark>");
					pw.print(menu.getRemark());
				pw.print("</remark>");
			
			pw.println("</menu>");
		}
		
		pw.println("</menulist>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
