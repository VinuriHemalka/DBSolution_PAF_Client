package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/FunderAPI")
public class FunderAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FunderServelet funderObj = new FunderServelet(); 
	
	public FunderAPI() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doget(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String outputString = funderObj.insertFunder(request.getParameter("funderName"),
					request.getParameter("phoneNumber"),
					request.getParameter("country"));
			
			response.getWriter().write(outputString);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				Map paras = getParasMap(request);
				
				String outputString = funderObj.updateFunder(
						paras.get("funder_ID").toString(),
						paras.get("funderName").toString(),
						paras.get("phoneNumber").toString(),
						paras.get("country").toString());
				
				response.getWriter().write(outputString);
						
			}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Map paras = getParasMap(request);
			String output = funderObj.deleteFunder(paras.get("funder_ID").toString());
			response.getWriter().write(output);
	}


	private static Map getParasMap(HttpServletRequest request) {
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
