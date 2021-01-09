package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//get writer
    	PrintWriter pw=res.getWriter();
    	//set response content type
    	res.setContentType("text/html");
    	String name=null,addrs=null,gender=null,ms=null,fbUrl=null,dob=null,tob=null,dtob1=null,dtob2=null,mob=null,wob=null,mail=null,color=null,search=null;
    	int age=0,fno=0,pin=0;
    	Long phone=0L,salary=0L;
		name=req.getParameter("name");
    	age=Integer.parseInt(req.getParameter("age"));
    	addrs=req.getParameter("addrs");
    	gender=req.getParameter("gender");
    	phone=Long.parseLong(req.getParameter("tel"));
    	ms=req.getParameter("ms");
    	String qlfy[]=req.getParameterValues("qlfy");
    	String crs[]=req.getParameterValues("crs");
    	String hb[]=req.getParameterValues("hb");
    	fbUrl=req.getParameter("fburl");
    	dob=req.getParameter("date");
        tob=req.getParameter("time");
    	dtob1=req.getParameter("datetime");
    	dtob2=req.getParameter("datetimelocal");
    	mob=req.getParameter("month");
    	wob=req.getParameter("week");
    	salary=Long.parseLong(req.getParameter("salary"));
    	mail=req.getParameter("mail");
    	color=req.getParameter("color");
    	fno=Integer.parseInt(req.getParameter("fno"));
    	pin=Integer.parseInt(req.getParameter("pin"));
    	search=req.getParameter("search");
    	
    	//write b.logic
    	if(gender.equalsIgnoreCase("M")) {
    		if(age<=5) {
    			pw.println("<h1 style='text-align:center;color:pink'> Master. You are a lil boy </h1>");
    		}
    		else if(age<=12) {
    			pw.println("<h1 style='text-align:center;color:red'> You are a young boy </h1>");
    		}
    		else if(age<=19) {
    			if(ms.equalsIgnoreCase("M")) {
    			pw.println("<h1 style='text-align:center;color:pink'>Mr. You are a married teenager boy </h1>");	
    			}
    			else {
    				pw.println("<h1 style='text-align:center;color:pink'> You are a teenager boy </h1>");	
    			}
    		}
    		else if(age<=30) {
    			if(ms.equalsIgnoreCase("M")) {
    				    pw.println("<h1 style='text-align:center;color:pink'> Mr You are a Married Man </h1>");
        			}
        			else {
        				pw.println("<h1 style='text-align:center;color:pink'> You are a Man..Go and marry </h1>");
        			}
    			
    		}
    		else if(age<=45) {
    			if(ms.equalsIgnoreCase("M")) {
    				pw.println("<h1 style='text-align:center;color:pink'>Mr. You are married person getting old </h1>");
    			}
    			else {
    				pw.println("<h1 style='text-align:center;color:pink'> You are getting old..and getting late for marriage </h1>");
    			}
    			
    		}
    		else {
    			if(ms.equalsIgnoreCase("M")) 
    				pw.println("<h1 style='text-align:center;color:pink'>mr.  You are a Married old man </h1>");
    		    else
    				pw.println("<h1 style='text-align:center;color:pink'> You are an old man ..you are too old for marriage</h1>");
    		
    	    }
    	}
    	else {
    		if(age<=5) {
    			pw.println("<h1 style='text-align:center;color:pink'> Master. You are a lil girl </h1>");
    		}
    		else if(age<=12) {
    			pw.println("<h1 style='text-align:center;color:red'> You are a young girl </h1>");
    		}
    		else if(age<=19) {
    			if(ms.equalsIgnoreCase("M")) {
    			pw.println("<h1 style='text-align:center;color:pink'>Mr. You are a married teenager girl </h1>");	
    			}
    			else {
    				pw.println("<h1 style='text-align:center;color:pink'> You are a teenager girl </h1>");	
    			}
    		}
    		else if(age<=30) {
    			if(ms.equalsIgnoreCase("M")) {
    				    pw.println("<h1 style='text-align:center;color:pink'> Mr You are a Married Woman </h1>");
        			}
        			else {
        				pw.println("<h1 style='text-align:center;color:pink'> You are a WoMan..Go and marry </h1>");
        			}
    			
    		}
    		else if(age<=45) {
    			if(ms.equalsIgnoreCase("M")) {
    				pw.println("<h1 style='text-align:center;color:pink'>Mr. You are married person getting old </h1>");
    			}
    			else {
    				pw.println("<h1 style='text-align:center;color:pink'> You are getting old..and getting late for marriage </h1>");
    			}
    			
    		}
    		else  {
    			if(ms.equalsIgnoreCase("M")) 
    				pw.println("<h1 style='text-align:center;color:pink'>mr.  You are a Married old  woman </h1>");
    		    else
    				pw.println("<h1 style='text-align:center;color:pink'> You are an old woman ..you are too old for marriage</h1>");
    		
    	    }
      }//else
    	
    	pw.println("<h1 style='text-align:center;color:cyan'>Displaying form Data </h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Name Is"+name +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Age is"+age +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Address is"+addrs +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Gender is"+gender +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Phone number is"+phone +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Maritial Status"+ms +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Qualification are </h1>");
    	pw.print("<h1 style='text-align:center;color:Black'>+" + Arrays.toString(qlfy) +"</h1>");
    	pw.print("<h1 style='text-align:center;color:Black'>+" + Arrays.toString(crs) +"</h1>");
    	pw.print("<h1 style='text-align:center;color:Black'>+" + Arrays.toString(hb) +"</h1>");
    	
    	pw.println("<h1 style='text-align:center;color:Black'>Facebook url is"+fbUrl +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'> Date of Birth is"+dob +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Time of Birth is"+tob +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Date and time of Birth 1"+dtob1 +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Date and time of Birth 2"+dtob2 +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Month of Birth"+mob +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Week of Birth"+wob +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Salary is"+salary +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Mail is"+mail +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Favouite color"+color +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Favouite number"+fno +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Pin"+pin +"</h1>");
    	pw.println("<h1 style='text-align:center;color:Black'>Search Keyword"+search +"</h1>");
    	
    	//add hyper link
    	pw.println("<a href='input.html'>Go Back</a>");
    	//close stream
    	pw.close();
 }//doPost(-,-)
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doPost(req, res);
    }//doGet(-,-)
}//class																						
