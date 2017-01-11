package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {

	String user = "root";
			String passwd = "";
			String driver = "com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/dna";
			String dbname="dna";
			Connection con;
	//PreparedStatement pstmt;
			
	public boolean doLogin(String username,String password){
		if(username.equals("admin") && password.equals("admin123")){
			return true;
		}
		return false;
	}
	
	public void insertUser(String name,String email,String password,String city,String contact,String priviledge) throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,passwd);
		String sql="insert into users(name,email,password,city,contact,priviledge) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		pstmt.setString(4, city);
		pstmt.setString(5, contact);
		pstmt.setString(6, priviledge);
		pstmt.executeUpdate();
		
		pstmt.close();
		db_close();
		
	}
	
	private void db_connect() throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,passwd);
	}
		
	private void db_close() throws SQLException{
		
		con.close();
	}
	
	public void deleteUser(String id) throws Exception{
		db_connect();
		String sql="delete from users where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		db_close();
	}
	
	public void editUser(String id,String name,String email,String password,String city,String contact,String priviledge) throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,passwd);
		String sql="update users set name = ?, email=?,  city =?, password = ?, contact =?, priviledge = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, city);
		pstmt.setString(4, password);
		pstmt.setString(5, contact);
		pstmt.setString(6, priviledge);
		pstmt.setString(7, id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		db_close();
		
	}
	public void editCategory(String id,String name) throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,passwd);
		String sql="update category set name = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		pstmt.setString(2, id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		db_close();
		
	}
	
	
	
	public void addCategory(String categoryname) throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,passwd);
		String sql="insert into category(name) values (?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, categoryname);
		pstmt.executeUpdate();
		
		pstmt.close();
		db_close();
		
	}
	
	public void deleteCategory(String id) throws Exception{
		db_connect();
		String sql="delete from category where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		db_close();
	}
	
	public boolean doLoginUser(String email,String password) throws Exception{
		db_connect();
		int count=0;
		String sql="Select count(*) AS count from users where email=? AND password=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			count = rst.getInt("count");
			
		}
		rst.close();
		pstmt.close();
		db_close();
		
		if(count !=0){
			return true;
		}
		else return false;
		
	}
	
	public String getPriviledge(String email) throws Exception{
		db_connect();
		String priviledge="";
		String sql="Select priviledge from users where email=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			priviledge = rst.getString("priviledge");
			
		}
		rst.close();
		pstmt.close();
		db_close();
		return priviledge;
	}
	public void insertNews(String email,String date,String cat_id,String price,String title,String short_desc,String desc,String credits) throws Exception{
		db_connect();
		//String sql = "INSERT INTO `news` (`title`, `price`, `category_id`, `date`, `short_description`, `description`, `user_email`, `credits`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String sql="insert into news(title,price,category_id,date,short_description,description,user_email,credits) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, price);
		pstmt.setInt(3, Integer.parseInt(cat_id));
		pstmt.setString(4, date);
		pstmt.setString(5, short_desc);
		pstmt.setString(6, desc);
		pstmt.setString(7, email);
		pstmt.setString(8, credits);
		pstmt.executeUpdate();
		
		pstmt.close();
		db_close();
	}

	public void addImage(String news_id,String name) throws Exception{
		String path = "upload/" + name;
		db_connect();
		String sql="update news set image = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, path);
		pstmt.setInt(2, Integer.parseInt(news_id));
		pstmt.executeUpdate();
		db_close();
	}
	
	public String fetchNewsId() throws Exception{
		db_connect();
		String news_id="";
		String sql="Select news_id as id from temp";
		PreparedStatement pstmt = con.prepareStatement(sql);
				
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()){
			news_id = rst.getString("id");
			
		}
		rst.close();
		pstmt.close();
		db_close();
		return news_id;
		
	}
}













