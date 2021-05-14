package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserAPI")
public class UserAPI extends HttpServlet {
	
		private static final long serialVersionUID = 1L;



		User userObj = new User();

		public UserAPI() {
			super();
		// TODO Auto-generated constructor stub
		}

		protected void doget(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String outputString = userObj.insertUser(request.getParameter("user_Name"),
		request.getParameter("password"),
		request.getParameter("userType"));
		

		response.getWriter().write(outputString);
		}

		protected void doPut(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		Map paras = getParasMap(request);

		String outputString = userObj.updateUser(
		paras.get("user_ID").toString(),
		paras.get("user_Name").toString(),
		paras.get("password").toString(),
		paras.get("userType").toString());

		response.getWriter().write(outputString);

		}
		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		Map paras = getParasMap(request);
		String output = userObj.deleteUser(paras.get("user_ID").toString());
		response.getWriter().write(output);
		}




		private Map getParasMap(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();

		try {
		Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
		scanner.close();

		String[] params = queryString.split("&");
		for (String param : params) {
		String[] p = param.split("=");
		map.put(p[0], p[1]);
		}
		}catch (Exception e) {
		}

		return map;

		}

		}

