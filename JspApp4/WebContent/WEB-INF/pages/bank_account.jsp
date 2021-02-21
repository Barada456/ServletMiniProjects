<%@page import="java.sql.*"%>

<%! 
	private Connection con;
	private PreparedStatement ps1=null,ps2=null;
	public void jspInit(){
		ServletConfig cg=null;
		String driver=null,url=null,dbuser=null,dbpwd=null;
		
		//get access to servletconfig object
		cg=getServletConfig();
		
		//read init parameters values from web.xml
		driver=cg.getInitParameter("driver");
		url=cg.getInitParameter("url");
		dbuser=cg.getInitParameter("dbuser");
		dbpwd=cg.getInitParameter("dbpwd");
		try{
			//load jdbc driver
			Class.forName(driver);
			//establish the  connection
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//create prepared statement object
			ps1=con.prepareStatement("INSERT INTO JSP_BANK_ACCOUNT VALUES(BANK_USER.NEXTVAL,?,?,?)");
			ps2=con.prepareStatement("SELECT ACCNO,ACCHNAME,IFSC,ADDRS FROM JSP_BANK_ACCOUNT");
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%

 String s1=request.getParameter("s1");
 System.out.println(s1);
if(s1.equalsIgnoreCase("Register")){
	//read form data
	String name=request.getParameter("Name");
	String ifsc=request.getParameter("Ifsc");
	String addrs=request.getParameter("Adress");
	
	System.out.println(name);
	System.out.println(ifsc);
	System.out.println(addrs);
	//set values to query string
	
	ps1.setString(1,ifsc);
	ps1.setString(2,addrs);
	ps1.setString(3,name);
	
	//execute query
	int count=ps1.executeUpdate();
	
	if(count==1){ %>
		<h1 Style="text-align:center;color=green">Registration Successfull..Account Created</h1>
    <%} //if
	else{ %>
		<h1 Style="text-align:center;color=red">Registration Creation Failed </h1>
	<%} //else 
	
}//if

else {
	//execute select query
	ResultSet rs=ps2.executeQuery();
	//process the result set  and print in html table
	%> 
	<table border="1" align="center" bgcolor="grey">
		<tr> <th>Account Number</th> <th>Account H Name</th>  <th>Ifsc</th> <th>Address</th>  </tr>
	
	<%
	while(rs.next()){
	%>
	<tr>
		<td><%=rs.getInt(1) %> </td>
		<td><%=rs.getString(2) %> </td>
		<td><%=rs.getString(3) %> </td>
		<td><%=rs.getString(4) %> </td>
	</tr>
	<%}%>
	</table>
	<a href="input.html">Home</a>
	
<%}
%>



<%! 
	public void jspDestroy(){
	//close objects
	try{
		if(ps1!=null){
			ps1.close();
		}
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	
	try{
		if(ps2!=null){
			ps2.close();
		}
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	try{
		if(con!=null){
			con.close();
		}
	}
	catch(SQLException se){
		se.printStackTrace();
	}
}//jspDestroy()
%>