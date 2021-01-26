package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=null;
		String link=null;
		Locale locales[]=null;
		//general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		link=req.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {
			//all language
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayLanguage()+"<br>");
			}
		}
		else if (link.equalsIgnoreCase("link2")) {
			//all countries
			locales=Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}
			
		}
		else {
			pw.println("Date and Time: "+new Date());
		}
		//add hyperlink
		pw.println("<a href='page.html'><b><i>Home</b></i></a>");
	}//doGet
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}//doPost

}//class
