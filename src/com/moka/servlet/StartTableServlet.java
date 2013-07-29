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
		// ��ȡ�����ӡ��
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// ��ȡ�����е�order����
		String orderTime = req.getParameter("orderTime");
		String userId = req.getParameter("userId");
		String tableId = req.getParameter("tableId");
		String personNum = req.getParameter("personNum");
		
		// �����Ƿ���ʵ������Order�����װ����
		Order order = new Order();
		order.setOrderTime(orderTime);
		order.setUserId(Integer.parseInt(userId));
		order.setTableId(Integer.parseInt(tableId));
		order.setPersonNum(Integer.parseInt(personNum));
		
		// �������ݴ���MySQL�ˣ����¶�Ӧ�����Ƿ����˵�״̬,����÷��صĶ����Ŵ��ؿͻ���
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
