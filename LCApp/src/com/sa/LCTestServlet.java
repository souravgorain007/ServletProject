package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletResponse;

public class LCTestServlet extends HttpServlet {
	static {
		System.out.println("LCTestServlet : Static block");
	}
	
	public LCTestServlet() {
		System.out.println("LCTestServlet : 0-ParamConstructor");
	}
	
	public void init(ServletConfig cg) {
		System.out.println("LCTestServlet : init-method");
	}
	public void service(ServletRequest req , ServletResponse res) throws ServletException,IOException{
		
		//general setting
		PrintWriter pw=null;
		Date d=new Date();
		res.setContentType("text/html");
		pw=res.getWriter();
		pw.println("<h1 style='color:red'><center>System Date and Time: "+d+"</center></h1>");
		pw.close();
		
	}
	public void destroy() {
		System.out.println("LCTestServlet : destroy()");
	}


}
