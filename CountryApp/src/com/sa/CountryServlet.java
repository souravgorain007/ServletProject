package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		String indStates[]= {"JH","WB","TN","KA","UP","JK"};
		String usStates[]= {"AS","DS","FD","RD","GF","BF"};
		String ausStates[]= {"ASD", "FDS", "HGD","SYN","RYN"};
		String country=null;
		
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		country=req.getParameter("country");
		if(country.equals("India")) {
			pw.println("States of India : "+Arrays.toString(indStates)+"</br>");
		}
		else if (country.equals("USA")) {
			pw.println("States of USA : "+Arrays.toString(usStates)+"</br>");
		}
		else {
			pw.println("States of Australia : "+Arrays.toString(ausStates)+"</br>");
		}
		
		//hyperlink
		pw.println("<a href='http://localhost:8081/CountryApp/page.html'><b></i>Home</b></i></a>");
		
		//close
		pw.close();
		
		
	}//doGet
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}//doPost

}//class
