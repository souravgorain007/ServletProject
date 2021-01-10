package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		
		PrintWriter pw=null;
		String name=null, tage=null, gender=null;
		int age=0;
		
		//general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		name=req.getParameter("name");
		gender=req.getParameter("gender");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		
		//write logic
		if(age>=21 && gender.equalsIgnoreCase("M")) {
			pw.println("<h1 style='color:green'><i><center>"+name+" your are eligible for marriage</center></i></h1>");
		}
		else if(age >= 18 && gender.equalsIgnoreCase("F")) {
			pw.println("<h1 style='color:green'><i><center>"+name+" your are eligible for marriage</center></i></h1>");
		}
		else {
			pw.println("<h1 styple='color:red'><i><center>"+name+" your are not eligible for marriage. your are child now</center></i></h1>");
		}
		
		//hyperlink
		pw.println("<a href='http://localhost:8081/MarriageApp/index.html'>Home</a>");
		
		//close
		pw.close();
		
		
	}//service

}//class
