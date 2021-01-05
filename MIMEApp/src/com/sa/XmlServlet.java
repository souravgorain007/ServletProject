package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		//set ContentType
		res.setContentType("text/xml");
		//create PrintWriter object
		PrintWriter pw=res.getWriter();
		//Write the logic for the WebPage
		pw.println("<table border='1'>");
		pw.println("<tr><th>Player</th><th>Role</th></tr>");
		pw.println("<tr><td>Dhoni</td><td>Caption</td></tr>");
		pw.println("<tr><td>Sachin</td><td>All Rounder</td></tr>");
		pw.println("</table>");
		//close PrintWriter
		pw.close();
		
	}//service

}//class
