package com.moka.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moka.dao.UserDao;
import com.moka.dao.impl.UserDaoImpl;
import com.moka.entity.User;

/**
 * 响应 Android客户端发来的请求
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// 获得响应的输出流
		PrintWriter pw = response.getWriter();
		// 获得客户端请求参数
		String account = request.getParameter("account");
		String password = request.getParameter("password");
System.out.println("account: " + account +  "; password: " + password);

		//实例化数据访问对象
		UserDao dao = new UserDaoImpl();
		User user = dao.login(account, password);
		if (user != null) {
			// 响应客户端内容，登录成功
			pw.print(build(user));
		} else {
			// 响应客户端内容，登录失败
			pw.print("0");
		}
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	// 此方法生成一个当前用户信息字符串返回给客户端
	private String build(User u) {
		String userMsg = "";
		userMsg += "id=" + u.getId();
		userMsg += ";";
		userMsg += "name=" + u.getName();
		return userMsg;
	}
}