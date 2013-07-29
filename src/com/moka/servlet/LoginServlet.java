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
 * ��Ӧ Android�ͻ��˷���������
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// �����Ӧ�������
		PrintWriter pw = response.getWriter();
		// ��ÿͻ����������
		String account = request.getParameter("account");
		String password = request.getParameter("password");
System.out.println("account: " + account +  "; password: " + password);

		//ʵ�������ݷ��ʶ���
		UserDao dao = new UserDaoImpl();
		User user = dao.login(account, password);
		if (user != null) {
			// ��Ӧ�ͻ������ݣ���¼�ɹ�
			pw.print(build(user));
		} else {
			// ��Ӧ�ͻ������ݣ���¼ʧ��
			pw.print("0");
		}
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	// �˷�������һ����ǰ�û���Ϣ�ַ������ظ��ͻ���
	private String build(User u) {
		String userMsg = "";
		userMsg += "id=" + u.getId();
		userMsg += ";";
		userMsg += "name=" + u.getName();
		return userMsg;
	}
}