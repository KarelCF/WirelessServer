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

import com.moka.dao.PayDao;
import com.moka.dao.impl.PayDaoImpl;
import com.moka.entity.QueryOrder;
import com.moka.entity.QueryOrderDetail;

public class QueryOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter ps = new PrintWriter(resp.getOutputStream());
		
		// 取得传来的orderId
		String id = req.getParameter("id");
		int orderId = Integer.parseInt(id);
		
		// 获取PayDao实例
		PayDao payDao = new PayDaoImpl();
		
		// 得到主订单数据实例
		QueryOrder order = payDao.getOrderById(orderId);
		
		// 得到订单明细数据实例列表
		List<QueryOrderDetail> list = payDao.getOrderDetailById(orderId);
		
		// 从主订单数据实例中取出数据
		String waiterName = order.getName();
		String orderTime = order.getOrderTime();
		int personNum = order.getPersonNum();
		int tableId = order.getTableId();
		
		// 将数据写进Html页面传回客户端
		ps.println("<HTML>");
		// 注：下面一句中head标签内要添加一条元数据，声明字符集为utf-8, 否则传回中文会显示乱码(可解决模拟器乱码)
		//<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">
		// 真机解决办法在webview中使用loadDataWithBaseURL()解决;
		ps.println("  <HEAD></HEAD>");
		ps.println("  <BODY>");
		ps.print("<table>");
			ps.print("<tr>");
			
				ps.print("<th>");
					ps.print("Order ID");
				ps.print("</th>");
				
				ps.print("<th>");
					ps.print("Waiter Name");
				ps.print("</th>");
				
				ps.print("<th>");
					ps.print("Order Time");
				ps.print("</th>");
				
				ps.print("<th>");
					ps.print("Person Num");
				ps.print("</th>");
				
				ps.print("<th>");
					ps.print("Table ID");
				ps.print("</th>");
				
			ps.print("</tr>");
			
			ps.print("<tr>");
				
				ps.print("<td>");
					ps.print(id);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(waiterName);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(orderTime);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(personNum);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(tableId);
				ps.print("</td>");
				
			ps.print("</tr>");
			
			ps.print("<tr>");
			
			ps.print("<th>");
				ps.print("Dish Name");
			ps.print("</th>");
			
			ps.print("<th>");
				ps.print("Price");
			ps.print("</th>");
			
			ps.print("<th>");
				ps.print("Dishes Num");
			ps.print("</th>");
			
			ps.print("<th>");
				ps.print("Total Price");
			ps.print("</th>");
			
			ps.print("<th>");
				ps.print("Remark");
			ps.print("</th>");
			
		ps.print("</tr>");
		
		// 循环取出所有明细数据,拼成html
		Iterator<QueryOrderDetail> iterator = list.iterator();
		while (iterator.hasNext()) {
			QueryOrderDetail detail = iterator.next();
			String dishName = detail.getDishName();
			int price = detail.getPrice();
			int dishNum = detail.getDishNum();
			int totalPrice = detail.getTotalPrice();
			String remark = detail.getRemark();
			ps.print("<tr>");
			
				ps.print("<td>");
					ps.print(dishName);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(price);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(dishNum);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(totalPrice);
				ps.print("</td>");
				
				ps.print("<td>");
					ps.print(remark);
				ps.print("</td>");
			
			ps.print("</tr>");
		}
		
		ps.print("</table>");
		ps.println("  </BODY>");
		ps.println("</HTML>");
		ps.flush();
		ps.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
