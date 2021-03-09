package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		String ss=null;
		String engine=null;
		String url=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		
		if(engine.equals("google")) {
			url="https://www.google.co.in/search?q="+ss;
		}
		else if(engine.equals("bing")) {
			url="https://www.bing.co.in/search?q="+ss;
		}
		else if(engine.equals("yahoo")) {
			url="https://www.bing.co.in/search?q="+ss;
		}
		System.out.println("Before SerachServlet: sendRedirect()");
		res.sendRedirect(url);
		System.out.println("After SearchServlet: sendRedirect()");
			
		
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}

}
