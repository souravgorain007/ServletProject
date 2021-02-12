package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet{
	
	public void service(ServletRequest req , ServletResponse res) throws ServletException,IOException {
		
		//general setting
		PrintWriter pw=null;
		Date date=null;
		res.setContentType("html/text");
		pw=res.getWriter();
		date=new Date();
		pw.println("<h1 style='color:red'><center>System date and time: "+date+"<center></h1>");
		pw.close();
		
	}

}
