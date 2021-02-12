package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int eno=0;
	
	public void init() {
		try {
		ServletConfig cg=getServletConfig();
		String s1=cg.getInitParameter("driver");
		String s2=cg.getInitParameter("dburl");
		String s3=cg.getInitParameter("dbuser");
		String s4=cg.getInitParameter("dbpwd");
		Class.forName(s1);
		con=DriverManager.getConnection(s2,s3,s4);
		ps=con.prepareStatement("select * from employee where E_NO=?");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//init
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		try {
		PrintWriter pw=null;
		res.setContentType("text/html");
		pw=res.getWriter();
		eno=Integer.parseInt(req.getParameter("eno"));
		ps.setInt(1,eno);
		rs=ps.executeQuery();
		pw.println("<h1 style='color:yellow'><center>Employee Information</center></h1>");
		if(rs.next()) {
			pw.println("Employee Number: "+rs.getInt(1));
			pw.println("<br>Employee Name: "+rs.getString(2));
			pw.println("<br>Employee Addrs: "+rs.getString(3));
			
		}
		rs.close();
		pw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//doGet
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
		}
		catch(Exception e){
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
