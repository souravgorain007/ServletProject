package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException {
		
		//set content type
		res.setContentType("text/html");
		//PrintWriter Object
		PrintWriter pw=res.getWriter();
		//write response
		Date d=new Date();
		pw.println("<b><i><center> Date and Time "+ d +"<center><i><b>");
		//close PrintWriter
		pw.close();
		
	}//service
}//class

