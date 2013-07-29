package com.moka.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.OrderDao;
import com.moka.dao.PayDao;
import com.moka.dao.impl.OrderDaoImpl;
import com.moka.dao.impl.PayDaoImpl;

public class PayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		// �ӿͻ���������ȡ�ö�����
		String id = req.getParameter("id");
		int orderId = Integer.parseInt(id);
		
		// ordertbl��isPay��λ, ��ʾ�Ѿ�����
		PayDao payDao = new PayDaoImpl();
		payDao.pay(orderId);
		
		// tabletbl�ж�Ӧ����flagλ����, ��ʾ��λ�ѿ�
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.updateTableStatusEx(orderId);
		
		pw.print("����ɹ�");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
