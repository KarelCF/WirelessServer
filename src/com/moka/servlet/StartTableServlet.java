package com.moka.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.OrderDao;
import com.moka.dao.impl.OrderDaoImpl;
import com.moka.entity.Order;

public class StartTableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		// 获取输出打印流
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// 读取请求中的order数据
		String orderTime = req.getParameter("orderTime");
		String userId = req.getParameter("userId");
		String tableId = req.getParameter("tableId");
		String personNum = req.getParameter("personNum");
		
		// 将他们放入实例化的Order对象封装起来
		Order order = new Order();
		order.setOrderTime(orderTime);
		order.setUserId(Integer.parseInt(userId));
		order.setTableId(Integer.parseInt(tableId));
		order.setPersonNum(Integer.parseInt(personNum));
		
		// 定单数据存入MySQL端，更新对应桌号是否有人的状态,并获得返回的订单号传回客户端
		OrderDao orderDao = new OrderDaoImpl();
		int orderId = orderDao.saveOrder(order);
		orderDao.updateTableStatus(Integer.parseInt(tableId));
		pw.print(orderId);
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
