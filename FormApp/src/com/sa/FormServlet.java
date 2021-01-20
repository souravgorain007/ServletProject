package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		String name=null, gender=null, addrs=null, ms=null, qulfy=null, hb[]=null, crs[]=null;
		int age=0;
		
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		
		name= req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gen");
		ms=req.getParameter("ms");
		addrs=req.getParameter("taddress");
		qulfy=req.getParameter("qulfy");
		hb=req.getParameterValues("hb");
		crs=req.getParameterValues("crs");
		if(gender.equalsIgnoreCase("M")) {
			if(age<=5)
				pw.println(name+"<h1><center> your are kid </center></h1>");
			else if(age<=12)
				pw.println(name+"<h1><center> your are  small boy </center></h1>");
			else if(age<=19)
				pw.println(name+"<h1><center> your are teenage boy</center></h1>");
			else if(age<=35)
				pw.println(name+"<h1><center> your are young man</center></h1>");
			else if(age<=50)
				pw.println(name+"<h1><center> your are middle man</center></h1>");
			else
				pw.println(name+"<h1><center> your are old age</center></h1>");
		}
		else if(gender.equalsIgnoreCase("F")) {
			if(age<=5)
				pw.println(name+"<h1><center> your are kid </center></h1>");
			else if(age<=12)
				pw.println(name+"<h1><center> your are  small girl</center></h1>");
			else if(age<=19)
				pw.println(name+"<h1><center> your are teenage girl</center></h1>");
			else if(age<=35)
				pw.println(name+"<h1><center> your are young girl</center></h1>");
			else if(age<=50)
				pw.println(name+"<h1><center> your are middle girl</center></h1>");
			else
				pw.println(name+"<h1><center> your are old age girl</center></h1>");
		}
		
		pw.println("<br>Name= "+name);
		pw.println("<br>Age= "+age);
		pw.println("<br>Address= "+addrs);
		pw.println("<br>Gender= "+gender);
		pw.println("<br>Marital status= "+ms);
		pw.println("<br>Qualification= "+qulfy);
		pw.println("<br>Courses= "+Arrays.toString(crs));
		pw.println("<br>Hobbies= "+Arrays.toString(hb));
		
		pw.println("<br><a href='http://localhost:8081/FormApp/form.html'>Home</a>");
		
	}//doGet
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}//doPost

}//class
