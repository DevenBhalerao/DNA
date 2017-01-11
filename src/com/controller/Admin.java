package com.controller;


import static com.beans.User.addDays;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.Account;
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //user-action
		if (action == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action"); // user-login
		if (action.equals("doLogin")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Account account = new Account();
			boolean status = account.doLogin(username, password);
			if (status) {
				account = null;
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				request.setAttribute("msg", "Invalid Login");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}

		}

		if (action.equals("create-user")) {
			request.getRequestDispatcher("create-user.jsp")
					.forward(request, response);
		}
		
		if (action.equals("create-user1")) {
			String name= request.getParameter("name");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			String city= request.getParameter("city");
			String contact= request.getParameter("contact");
			String priviledge= request.getParameter("priviledge");
			
			Account account=new Account();
			try {
				account.insertUser(name,email,password,city,contact,priviledge);
			} catch (Exception e) {
				//request.getRequestDispatcher("error.jsp")
				//.forward(request, response);
			}
			request.setAttribute("msg", "User Added to the System");
			account=null;
			request.getRequestDispatcher("create-user.jsp").forward(request, response);
		}

		if (action.equals("user-delete")) {
			String id = request.getParameter("id");
			Account account=new Account();
			try {
				account.deleteUser(id);
			} catch (Exception e) {
				
			}
			account=null;
			request.setAttribute("msg", "User Deleted from System!!");
			request.getRequestDispatcher("manage-user.jsp")
					.forward(request, response);
		}
		
		if (action.equals("user-edit")) {
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			request.getRequestDispatcher("user-edit.jsp")
					.forward(request, response);
		}
		
		if (action.equals("manage-user")) {
			request.getRequestDispatcher("manage-user.jsp")
					.forward(request, response);
		}

		if (action.equals("user-edit1")) {
			String name= request.getParameter("name");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			String city= request.getParameter("city");
			String contact= request.getParameter("contact");
			String priviledge= request.getParameter("priviledge");
			
			Account account=new Account();
			String id= request.getParameter("id");
			try {
				account.editUser(id,name,email,password,city,contact,priviledge);
			} catch (Exception e) {
				
			}
			request.setAttribute("msg", "User details Edited!!");
			request.getRequestDispatcher("manage-user.jsp")
					.forward(request, response);
		}
		
		if (action.equals("create-category")) {
			request.getRequestDispatcher("create-category.jsp")
					.forward(request, response);
		}
		if (action.equals("create-category1")) {
			String categoryname =request.getParameter("category"); 
			Account account=new Account();
			try {
				account.addCategory(categoryname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "Category Added!!");
			request.getRequestDispatcher("create-category.jsp")
					.forward(request, response);
		}
		if (action.equals("category-delete")) {
			String id = request.getParameter("id");
			Account account=new Account();
			try {
				account.deleteCategory(id);
			} catch (Exception e) {
				
			}
			account=null;
			request.setAttribute("msg", "category Deleted from System!!");
			request.getRequestDispatcher("manage-category.jsp")
					.forward(request, response);
		}
		if (action.equals("category-edit")) {
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			request.getRequestDispatcher("category-edit.jsp")
					.forward(request, response);
		}
		
		if (action.equals("category-edit1")) {
			String name= request.getParameter("name");		
			Account account=new Account();
			String id= request.getParameter("id");
			try {
				account.editCategory(id,name);
			} catch (Exception e) {
				
			}
			account=null;
			request.setAttribute("msg", "Category Name Edited!!");
			request.getRequestDispatcher("manage-category.jsp")
					.forward(request, response);
		}
				

		if (action.equals("manage-category")) {
			request.getRequestDispatcher("manage-category.jsp")
					.forward(request, response);
		}
				
				
		if (action.equals("user-login")) {
			request.getRequestDispatcher("userlogin.jsp")
					.forward(request, response);
		}
		if (action.equals("news-create1")) {
			String email=request.getParameter("email");
			String date=request.getParameter("date");
			String cat_id=request.getParameter("category");
			String price=request.getParameter("price");
			String title=request.getParameter("title");
			String short_desc=request.getParameter("short-description");
			String desc=request.getParameter("description");
			String credits=request.getParameter("credits");
			Account account=new Account();
			try {
				account.insertNews(email,date,cat_id,price,title,short_desc,desc,credits);
			} catch (Exception e) {
				}
			
			request.setAttribute("msg", "News Created!!");
			request.getRequestDispatcher("news-creator.jsp")
					.forward(request, response);
		}
		
		
		if(action.equals("doLogin-user")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Account account=new Account();
			boolean status=false;
			try {
				 status = account.doLoginUser(email, password);
			} catch (Exception e) {
				
			}
			String priviledge = "";
			if(status == true){
				try {
					priviledge = account.getPriviledge(email); //""
					account=null;
				} catch (Exception e) {
					}
				if(priviledge.equals("")){
					request.setAttribute("msg", "Re-Enter Email/Password");
					request.getRequestDispatcher("userlogin.jsp")
					.forward(request, response);
				}
				if(priviledge.equals("1")){
							
					session.setAttribute("email", email);
					request.getRequestDispatcher("news-creator.jsp")
					.forward(request, response);
				}
				if(priviledge.equals("2")){
					session.setAttribute("email", email);
					
					request.getRequestDispatcher("ad-executive.jsp")
					.forward(request, response);
				}
			}
			else{
				request.setAttribute("msg", "Invalid Email/Password");
				request.getRequestDispatcher("userlogin.jsp")
				.forward(request, response);
			}
		}

			if(action.equals("add-news")){
				Date d1 = addDays(new Date(), 1);
				request.setAttribute("date", d1);
				request.getRequestDispatcher("news-create.jsp")
				.forward(request, response);
		}
			
			if(action.equals("add-banner")){
				
				request.getRequestDispatcher("add-banner.jsp")
				.forward(request, response);
		}
			if(action.equals("add-banner1")){
				//process only if its multipart content
				 final String UPLOAD_DIRECTORY = "C:/Users/KEC/workspace/DNA/WebContent/upload"  ; 
				 String name="";
				 
				 
				//process only if its multipart content
			        if(ServletFileUpload.isMultipartContent(request)){
			            try {
			                List<FileItem> multiparts = new ServletFileUpload(
			                                         new DiskFileItemFactory()).parseRequest(request);
			              
			                for(FileItem item : multiparts){
			                    if(!item.isFormField()){
			                         name = new File(item.getName()).getName();
			                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
			                    }
			                }
			                String path=UPLOAD_DIRECTORY +"/"+ name;
			               //File uploaded successfully
			               request.setAttribute("message", "File Uploaded Successfully");
			               request.setAttribute("name", name);
			               
			            } catch (Exception ex) {
			               request.setAttribute("message", "File Upload Failed due to " + ex);
			            }          
			         
			        }else{
			            request.setAttribute("message",
			                                 "Sorry this Servlet only handles file upload request");
			        }
			    
			        Account account = new Account();
			        try {
			        	String news_id = account.fetchNewsId();
						account.addImage(news_id,name);
					} catch (Exception e) {
						
					}
			        request.getRequestDispatcher("ad-executive.jsp").forward(request, response);
				 
				
		}
			
	}

}












