package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException {
		
		PrintWriter pw=null;
		
		RequestDispatcher rd1=req.getRequestDispatcher("/headerurl");
		rd1.include(req, res);
		
		
		res.setContentType("text/html");
		pw=res.getWriter();
		
		pw.println("<br><br><br><br><b><i>Internal Error</b><i>");
		pw.println("<a href='input.html'>Home</a>");
		
		RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
		
		pw.close();
		
	}//doGet
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}

}
