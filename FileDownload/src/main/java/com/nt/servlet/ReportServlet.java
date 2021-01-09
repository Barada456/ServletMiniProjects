package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

@WebServlet("/reporturl")
public class ReportServlet extends HttpServlet {
	private static final String DOWNLOAD_QUERY="SELECT SNO,SNAME,SPHOTO,SRESUME FROM FILE_UPLOAD ";
	@Resource(name="DsJndi")
	private DataSource ds;
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletOutputStream sos=null;
		File file=null;
		String filePath=null;
		String mimeType=null;
		InputStream is=null;
		//general settings
		sos=res.getOutputStream();
		//set content type
		res.setContentType("text/html");
		//read additional param value
		param=req.getParameter("type");
		if(param.equalsIgnoreCase("report")) {
			try {
				//get pooled connection object
				con=ds.getConnection();
				//create preparedstatement object
				ps=con.prepareStatement(DOWNLOAD_QUERY);
				//execute query
				rs=ps.executeQuery();
				//process the result set obj and display report as html table
				sos.println("<table border='1' bgcolor='cyan' align='center'>");
				sos.println("<tr><th>STUDENT NO</th><th>STUDENT NAME</th><th>STUDENT PHOTO</th><th>STUDENT RESUME</th></tr>");
				while(rs.next()) {
					sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td><a href='reporturl?type=download&path="+rs.getString(3)+"'>Download</a></td><td><a href='reporturl?type=download&path="+rs.getString(4)+"'>Download</a></td></tr>");
				}//while
				sos.println("</table>");
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				sos.println("Internal DB Problem");
			}
			catch(Exception e) {
				e.printStackTrace();
				sos.println("Internal Error");
			}
			finally {
				//close jdbc objects
				try {
					if(rs!=null) 
						rs.close();
				}	
				catch(SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if(ps!=null) 
						ps.close();
				}	
				catch(SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if(con!=null) 
						con.close();
				}	
				catch(SQLException se) {
					se.printStackTrace();
				}
					
				
			}//finally
			
			
		}//if
		else {//downloading
			//get file location from hyperlink as req param value
			filePath=req.getParameter("path");
			//create java.io.File class object
			file=new File(filePath);
			//get the length of the file and make it response length
			res.setContentLengthLong(file.length());
			//get the mimetype of the file and make it as response content object
			mimeType=getServletContext().getMimeType(filePath);
			res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
			//create input stream pointing to that file
			is=new FileInputStream(file);
			//set value to content disposition response header
			res.addHeader("Content-Disposition","attachment;filename="+file.getName());
			//copy file content to response object
			IOUtils.copy(is,sos);
			//close stream
			is.close();
			sos.close();
		}
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
