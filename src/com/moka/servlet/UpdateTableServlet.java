package com.moka.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.UpdateDao;
import com.moka.dao.impl.UpdateDaoImpl;
import com.moka.entity.Table;

public class UpdateTableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// 获取所有桌号信息列表
		UpdateDao updateDao = new UpdateDaoImpl();
		List<Table> tableList = updateDao.getTableList();
		
		// 将所有信息以xml格式输出 
		pw.println("<?xml version='1.0' encoding='UTF-8'?>");
		pw.println("<tablelist>");
				
		for (int i = 0; i < tableList.size(); i++) {
			Table table = tableList.get(i);
			pw.println("<table>");
			
				pw.print("<id>");
					pw.print(table.getId());
				pw.print("</id>");
				
				pw.print("<num>");
					pw.print(table.getNum());
				pw.print("</num>");
				
				pw.print("<description>");
					pw.print(table.getDescription());
				pw.print("</description>");
			
			pw.println("</table>");
		}
		
		pw.println("</tablelist>");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
