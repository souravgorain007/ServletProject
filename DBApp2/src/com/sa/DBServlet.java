package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet{
	
	Connection con=null;
	PreparedStatement ps=null;
	
	public static final String GET_EMPLOYEE_DETAILS=("select * from employee where E_NO=?");
	
	public void init() {
		String driver=null, url=null, dbuser=null, dbpwd=null;
		
		try {
		ServletContext sc=getServletContext();
		
		driver=sc.getInitParameter("driver");
		url=sc.getInitParameter("url");
		dbuser=sc.getInitParameter("dbuser");
		dbpwd=sc.getInitParameter("dbpwd");
		
		Class.forName(driver);
		con=DriverManager.getConnection(url,dbuser,dbpwd);
		ps=con.prepareStatement(GET_EMPLOYEE_DETAILS);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		int no=0;
		ResultSet rs=null;
		
		try{
		
		RequestDispatcher rd1=req.getRequestDispatcher("/headerurl");
		rd1.include(req, res);
		
		res.setContentType("text/html");
		pw=res.getWriter();
		
		no=Integer.parseInt(req.getParameter("eno"));
		
			ps.setInt(1, no);
			rs=ps.executeQuery();
						
			if(rs.next()) {
				pw.println("<br><br>Employee No: "+rs.getInt(1));
				pw.println("<br>Employee Name: "+rs.getString(2));
				pw.println("<br>Employee Addr"+rs.getString(3));
			}
			else {
				pw.println("<b>No Record found</b>");
			}
			
			pw.println("<br><a href='input.html'>Home</a>");
			
			RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
				rd2.include(req, res);
				
				rs.close();
				pw.close();
			
		}//try
		catch(Exception e) {
			RequestDispatcher rd3=req.getRequestDispatcher("/errurl");
			rd3.include(req, res);
		}//catch
		
		
	}//doGet
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}
	
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//destroy
	

}//class
