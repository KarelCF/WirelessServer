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
		// 此句将请求的编码设置为utf-8, 同时在
		// jdbc中获得连接的url后加上"?useUnicode=true&characterEncoding=utf-8"
		// 就可以解决上传到MySQL的中文乱码问题
		req.setCharacterEncoding("utf-8");
		// 获取输出打印流
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		
		// 读取请求中的order数据
		String orderId = req.getParameter("orderId");
		String menuId = req.getParameter("menuId");
		String dishNum = req.getParameter("dishNum");
		String remark = req.getParameter("remark");
		
		// 将数据添加到一个OrderDetail表对象实例
		OrderDetail detail = new OrderDetail();
		detail.setOrderId(Integer.parseInt(orderId));
		detail.setMenuId(Integer.parseInt(menuId));
		detail.setNum(Integer.parseInt(dishNum));
		detail.setRemark(remark);
		
		// 定单数据存入MySQL端，更新对应桌号是否有人的状态,并获得返回的订单号传回客户端
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.saveOrderDetail(detail);
		pw.print("加菜成功");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
