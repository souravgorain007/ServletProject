package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DateServlet extends HttpServlet {
	
	public void service(ServletRequest req , ServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		Date d=null;
		
		// general setting
	    res.setContentType("text/html");
	    pw=res.getWriter();
	    d=new Date();
	    pw.println("<h1 style='color:red'><center>Date and Time : "+d+"</center></h1>");
	    //close
	    pw.close();
	}//service

}//class
