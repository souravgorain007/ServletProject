package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=null;
		String comp=null;
		int val1,val2=0;
		//general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		comp=req.getParameter("s1");
		if(comp.equals("link1")) {
			pw.println("System date and time: "+new Date());
		}
		else if (comp.equals("link2")) {
			pw.println("System Properties: "+System.getProperties());
		}
		else if (comp.equals("add")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Addition: "+(val1+val2));
			}
		else if(comp.equals("sub")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Subtraction: "+(val1+val2));
		}
		else {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Multiplication: "+(val1*val2));
		}
		//hyperlink
		pw.println("<a href='index.html'>Home</a>");
	}//doGet
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}//doPost
	
}//class
