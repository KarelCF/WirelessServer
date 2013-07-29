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
		// 从客户端请求中取得订单号
		String id = req.getParameter("id");
		int orderId = Integer.parseInt(id);
		
		// ordertbl中isPay置位, 表示已经付款
		PayDao payDao = new PayDaoImpl();
		payDao.pay(orderId);
		
		// tabletbl中对应桌号flag位清零, 表示桌位已空
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.updateTableStatusEx(orderId);
		
		pw.print("结算成功");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
