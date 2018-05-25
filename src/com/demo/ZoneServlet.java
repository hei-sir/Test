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
 * Servlet implementation class ZoneServlet
 */
@WebServlet("/ZoneServlet")
public class ZoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Zone> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
	       response.setCharacterEncoding("utf-8");
	         PrintWriter out=response.getWriter();
	        
	        list=PrapareData();
	 //        out.write(list.toString());
	        
	        
	        JSONArray array=new JSONArray();
	         
	         for(Zone bean: list)
	        {
	            JSONObject obj=new JSONObject();
	             
	             try{
	            	 
	                 obj.put("id",bean.getId() );
	                 obj.put("username", bean.getUsername());
	                 obj.put("name", bean.getName());
	                 System.out.println(bean.getContent());
	            	 obj.put("content", bean.getContent());
	                 obj.put("imagePath", bean.getImagePath());
	                 obj.put("time", bean.getTime());	  
	                 obj.put("image", bean.getImage());
	                 
	                 
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
	
	private List<Zone> PrapareData()
	     {
		Zone u=new Zone();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        String sql="select * from Zone";
        int rows=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			
			
			
			
			rs = pstmt.executeQuery();
			list=new ArrayList<Zone>();
			if(rs.first()){
				do{
					u.setId(rs.getInt("id"));
					u.setUsername(rs.getString("username"));
				    u.setName(rs.getString("name"));
				    u.setContent(rs.getString("content"));
				    u.setTime(rs.getString("time"));
				    u.setImagePath(rs.getString("imagePath"));	
				    u.setImage(rs.getBytes("image"));
				
				 Zone Zone1=new Zone();
				 Zone1.setId(u.getId());
				 Zone1.setUsername(u.getUsername());
				    Zone1.setName(u.getName());
			        Zone1.setContent(u.getContent());
			        Zone1.setTime(u.getTime());
			        Zone1.setImagePath(u.getImagePath());
			        Zone1.setImage(u.getImage());
			        list.add(Zone1);
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
