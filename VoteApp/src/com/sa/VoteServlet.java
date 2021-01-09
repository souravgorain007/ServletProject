package com.sa;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException {
	
		PrintWriter pw=null;
		String name=null, tage=null ;
		int age=0;
		
		//set ContentType
		res.setContentType("text/html");
		//general setting
		pw=res.getWriter();
		name=req.getParameter("name");
	    tage=req.getParameter("age");
	    age=Integer.parseInt(tage);
		//Logic
	    
	    if(age>=18) {
	    	pw.println("<h1 style='color:red'>"+name+" your are eligible for voting</h1>");
	    }
	   	    else {
	    	pw.println("<h1 styple='color:green'>"+name+ "you are not eligible for voting</h1>");
	   	    } 
	    //hyperlink
	    pw.println("<a href='http://localhost:8081/VoteApp/index.html'>Home page</a>");
	    
	    //close 
		pw.close();
	
	}//doPost

}//class
