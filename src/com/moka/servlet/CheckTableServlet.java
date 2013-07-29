package com.moka.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.CheckDao;
import com.moka.dao.impl.CheckDaoImpl;
import com.moka.entity.CheckedTable;

public class CheckTableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		CheckDao checkDao = new CheckDaoImpl();
		List<CheckedTable> list = checkDao.getTableList();
		// 调用生成结果字符串的方法
		pw.print(buildResult(list));
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private String buildResult(List<CheckedTable> list) {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			CheckedTable table = list.get(i);
			int id = table.getId();
			int flag = table.getFlag();
			String description = table.getDescription(); 
			result += "id:" + id + ";flag:" + flag + ";description:" + description + ",";
		}
		return result;
	}

}
