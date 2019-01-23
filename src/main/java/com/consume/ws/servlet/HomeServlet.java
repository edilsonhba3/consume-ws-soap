package com.consume.ws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.consume.ws.soap.*;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		
		CalculatorSoap service = new Calculator().getCalculatorSoap();
		
		Integer res = service.add(number1, number2);
		
		System.out.println("response from web service == "+res);
				
		System.out.println("number1 == "+number1);
		
		System.out.println("number2 == "+number2);
		
		response.setContentType("text/html");
		response.getWriter().append("<h3>Response from web service method add(number1, number2) result = ").append(res +"</h3>");
	}

}
