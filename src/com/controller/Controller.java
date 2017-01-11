package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action==null){
			request.getRequestDispatcher("client-index.jsp").forward(request, response);
		}
		else{
			doPost(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equals("show-news")){
			String category = request.getParameter("category");
				if(session.getAttribute("email") != null){
					request.setAttribute("category", category);
					request.getRequestDispatcher("show-news.jsp").forward(request, response);
				}
				else{
					request.setAttribute("category", category);
					request.getRequestDispatcher("client-login.jsp").forward(request, response);
				}
			
			
		}
		
		if(action.equals("doLogin-client")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String category = request.getParameter("category");
			
			User user=new User();
			boolean status = user.chkClientLogin(email,password);
			user=null;
			if(status ==true){
				session.setAttribute("email", email);
				request.setAttribute("category", category);
				request.getRequestDispatcher("show-news.jsp").forward(request, response);
				
			}
		}
		
		if(action.equals("client-login")){
			request.getRequestDispatcher("client-login1.jsp").forward(request, response);
		}
		
		if(action.equals("doLogin-client1")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user=new User();
			boolean status = user.chkClientLogin(email,password);
			if(status ==true){
				session.setAttribute("email", email);
				//request.setAttribute("status", "loggedIn");
				request.getRequestDispatcher("client-index.jsp").forward(request, response);
				
			}
		}
	}

}








