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
import com.moka.entity.OrderDetail;

public class OrderDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		// �˾佫����ı�������Ϊutf-8, ͬʱ��
		// jdbc�л�����ӵ�url�����"?useUnicode=true&characterEncoding=utf-8"
		// �Ϳ��Խ���ϴ���MySQL��������������
		req.setCharacterEncoding("utf-8");
		// ��ȡ�����ӡ��
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// ��ȡ�����е�order����
		String orderId = req.getParameter("orderId");
		String menuId = req.getParameter("menuId");
		String dishNum = req.getParameter("dishNum");
		String remark = req.getParameter("remark");
		
		// ��������ӵ�һ��OrderDetail�����ʵ��
		OrderDetail detail = new OrderDetail();
		detail.setOrderId(Integer.parseInt(orderId));
		detail.setMenuId(Integer.parseInt(menuId));
		detail.setNum(Integer.parseInt(dishNum));
		detail.setRemark(remark);
		
		// �������ݴ���MySQL�ˣ����¶�Ӧ�����Ƿ����˵�״̬,����÷��صĶ����Ŵ��ؿͻ���
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.saveOrderDetail(detail);
		pw.print("�Ӳ˳ɹ�");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
