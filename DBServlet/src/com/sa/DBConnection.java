package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnection extends HttpServlet {
	
	Connection con=null;
	PreparedStatement ps=null;
	int eno=0;
	
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			ps=con.prepareStatement("select * from employee where E_NO=?");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		try {
			
		PrintWriter pw=null;
		
		res.setContentType("text/html");
		pw=res.getWriter();
		eno=Integer.parseInt(req.getParameter("eno"));
		ps.setInt(1, eno);
		ResultSet rs=ps.executeQuery();
		pw.println("<h1 style='color:red'><center>Employee Infromation</center></h1><br>");
		if(rs.next())
		{
			pw.println("<br>Employee No: "+rs.getInt(1));
			pw.println("<br>Employee Name: "+rs.getString(2));
			pw.println("<br>Employee Addrs: "+rs.getString(3));
		}
		else {
			pw.println("<br>No Employee Found");
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}

}
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
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
	}
}
