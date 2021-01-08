package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		Calendar calendar=null;
		int hour= 0;
		
		//set ContentType
		res.setContentType("text/html");
		//general setting
		pw=res.getWriter();
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//condition
		if(hour<=12)
			pw.println("<h1 style='color:red'><center>Good Morning</center></h1>");
		else if(hour<=17)
			pw.println("<h1 style='color:orange'><center>Good Evening</center></h1>");
		else
			pw.println("<h1 style='color:black'><center>Good Night</center></h1>");
		pw.println("<a href='http://localhost:8081/WishApp/page.html'>Home</a>");
		
		//close connection
		pw.close();
		
	}//service

}//class
