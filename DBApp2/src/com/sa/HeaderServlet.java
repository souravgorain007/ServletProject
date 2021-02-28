package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		
		res.setContentType("text/html");
		pw=res.getWriter();
		
		pw.println("<marquee><h1 style='color:Red'>IT Technologies</h1></marquee>");
		
	}//doGet
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}

}
