package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void init() {
		try {
			ServletContext sc=getServletContext();
			String s1=sc.getInitParameter("driver");
			String s2=sc.getInitParameter("dburl");
			String s3=sc.getInitParameter("dbuser");
			String s4=sc.getInitParameter("dbpwd");
			
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			ps=con.prepareStatement("select * from employee where E_No=?");
			sc.log("System Date and Time: "+new java.util.Date());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//init
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		try {
		PrintWriter pw=null;
		//general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		int eno=Integer.parseInt(req.getParameter("eno"));
		ps.setInt(1, eno);
		rs=ps.executeQuery();
		pw.println("<h1 style='color:Green'><center>Employee Details</center></h1>");
		if(rs.next()) {
			pw.println("<br> Employee ID: "+rs.getInt(1));
			pw.println("<br> Employee Name: "+rs.getString(2));
			pw.println("<br> Employee Addrs: "+rs.getString(3));
		}
		pw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}//doPost
	
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
		try {
			if(rs!=null)
				rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//destroy

}
