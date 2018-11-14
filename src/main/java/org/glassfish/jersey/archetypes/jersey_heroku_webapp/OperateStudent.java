package org.glassfish.jersey.archetypes.jersey_heroku_webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.archetypes.jersey_heroku_webapp.StudentBean;

@Path("student")
public class OperateStudent {
	Connection con;
	Statement s;
	ResultSet rs;
	@Context ServletContext application;
	String dbUserName;
	String dbPassword;
	String jdbcDriver;
	String urlString;
	
	@GET
	@Path("name/{sname}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentBean getByName(@PathParam("sname") String sname)
	{
	
	 dbUserName=application.getInitParameter("dbUserName");
	 dbPassword=application.getInitParameter("dbPassword");
	 jdbcDriver=application.getInitParameter("jdbcDriver");
	 urlString=application.getInitParameter("urlString");
	 String query="select * from students where sname ='" + sname + "';";
		 
	 StudentBean sb=null;
	 try{
			Class.forName(jdbcDriver);  
			con=DriverManager.getConnection(urlString,dbUserName,dbPassword);  
			s=con.createStatement();  
			rs=s.executeQuery(query);
			
			if(rs.next())
			{
				
				sb=new StudentBean();
				sb.setRoll(rs.getInt(1));
				sb.setSname(rs.getString(2));
				sb.setClas(rs.getInt(3));
				sb.setSchool(rs.getString(4));
				sb.setSession(rs.getInt(5));
				sb.setDob(rs.getString(6));
				sb.setAge(rs.getInt(7));
				sb.setDoa(rs.getString(8));
				sb.setGender(rs.getString(9));
				sb.setSmobile(rs.getString(10));
				sb.setSemail(rs.getString(11));
				sb.setMname(rs.getString(12));
				sb.setFname(rs.getString(13));
				sb.setMmobile(rs.getString(14));
				sb.setFmobile(rs.getString(15));
				
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		return sb;
	 
	}
	@GET
	@Path("roll/{sroll}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentBean getByRoll(@PathParam("sroll") int sroll)
	{
	
	 dbUserName=application.getInitParameter("dbUserName");
	 dbPassword=application.getInitParameter("dbPassword");
	 jdbcDriver=application.getInitParameter("jdbcDriver");
	 urlString=application.getInitParameter("urlString");
	 String query="select * from students where roll =" + String.valueOf(sroll) + ";";
		 
	 StudentBean sb=null;
	 try{
			Class.forName(jdbcDriver);  
			con=DriverManager.getConnection(urlString,dbUserName,dbPassword);  
			s=con.createStatement();  
			rs=s.executeQuery(query);
			
			if(rs.next())
			{
				sb=new StudentBean();
				sb.setRoll(rs.getInt(1));
				sb.setSname(rs.getString(2));
				sb.setClas(rs.getInt(3));
				sb.setSchool(rs.getString(4));
				sb.setSession(rs.getInt(5));
				sb.setDob(rs.getString(6));
				sb.setAge(rs.getInt(7));
				sb.setDoa(rs.getString(8));
				sb.setGender(rs.getString(9));
				sb.setSmobile(rs.getString(10));
				sb.setSemail(rs.getString(11));
				sb.setMname(rs.getString(12));
				sb.setFname(rs.getString(13));
				sb.setMmobile(rs.getString(14));
				sb.setFmobile(rs.getString(15));
				
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return sb;
	 
	}

}
