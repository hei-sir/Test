package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
	       response.setCharacterEncoding("utf-8");
	         PrintWriter out=response.getWriter();
	        
	        list=PrapareData();
	 //        out.write(list.toString());
	        
	        
	        JSONArray array=new JSONArray();
	         
	         for(User bean: list)
	        {
	            JSONObject obj=new JSONObject();
	             
	             try{
	            	 
	                 obj.put("id",bean.getId() );
	                 obj.put("user", bean.getUser());
	                 obj.put("number", bean.getNumber());
	            	 obj.put("name", bean.getName());
	            	 obj.put("phone",bean.getPhone());
	                 obj.put("school", bean.getSchool());
	                 obj.put("grade", bean.getGrade());
	                 obj.put("clsses", bean.getClsses());	                 
	                 obj.put("identity", bean.getIdentity());
	                 obj.put("notice", bean.getNotice());
	                 obj.put("photo", bean.getPhoto());
	                 
	                 
	             }
	             catch(Exception e){
	                 
	            }
	             
	            
	         array.add(obj);
	            
	             
	         }
	         out.write(array.toString());
	 //        out.write("nihao!!!!");
	         out.flush();
	         out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 super.doGet(request, response);
		}
		
		private List<User> PrapareData()
		     {
			User u=new User();
		   	Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				
				
				
				
				rs = pstmt.executeQuery();
				list=new ArrayList<User>();
				if(rs.first()){
					do{
						u.setId(rs.getInt("id"));
						u.setPassword(rs.getString("password"));
					    u.setName(rs.getString("name"));
					    u.setPhone(rs.getString("phone"));
					    u.setIdentity(rs.getString("identity"));
					    u.setSchool(rs.getString("school"));
					    u.setGrade(rs.getString("grade"));
					    u.setClsses(rs.getString("clsses"));
					    u.setNumber(rs.getString("number"));
					    u.setUser(rs.getString("user"));;
					    u.setNotice(rs.getString("notice"));
					    u.setPhoto(rs.getString("photo"));
					
					 User user1=new User();
					 user1.setId(u.getId());
					 user1.setPassword(u.getPassword());
					    user1.setUser(u.getUser());
				        user1.setName(u.getName());
				        user1.setPhone(u.getPhone());
				        user1.setIdentity(u.getIdentity());
				        user1.setSchool(u.getSchool());
				        user1.setGrade(u.getGrade());
				        user1.setClsses(u.getClsses());
				        user1.setNumber(u.getNumber());
				        user1.setNotice(u.getNotice());
				        user1.setPhoto(u.getPhoto());
				        list.add(user1);
					}while(rs.next());
					
				}
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						pstmt=null;
					}
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						conn=null;
					}
				}
			}
	      
	        
	        return list;
		     
		    }
}
