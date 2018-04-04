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
 * Servlet implementation class QaServet
 */
@WebServlet("/QaServet")
public class QaServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Qa> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaServet() {
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
	         
	         for(Qa bean: list)
	        {
	            JSONObject obj=new JSONObject();
	             
	             try{
	            	 
	                 obj.put("id",bean.getId() );
	                 obj.put("sname", bean.getSname());
	                 obj.put("tname", bean.getTname());
	                 System.out.println(bean.getContent());
	            	 obj.put("content", bean.getContent());
	                 obj.put("answer", bean.getAnswer());
	                 obj.put("time", bean.getTime());
	                 obj.put("status", bean.getStatus());	                 
	                 
	                 
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
	
	private List<Qa> PrapareData()
	     {
		Qa u=new Qa();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        String sql="select * from qa";
        int rows=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			
			
			
			
			rs = pstmt.executeQuery();
			list=new ArrayList<Qa>();
			if(rs.first()){
				do{
					u.setId(rs.getInt("id"));
					u.setSname(rs.getString("sname"));
				    u.setTname(rs.getString("tname"));
				    u.setContent(rs.getString("content"));
				    u.setTime(rs.getString("time"));
				    u.setAnswer(rs.getString("answer"));
				    u.setStatus(rs.getString("status"));				   
				
				 Qa qa1=new Qa();
				 qa1.setId(u.getId());
				 qa1.setSname(u.getSname());
				    qa1.setTname(u.getTname());
			        qa1.setContent(u.getContent());
			        qa1.setTime(u.getTime());
			        qa1.setAnswer(u.getAnswer());
			        qa1.setStatus(u.getStatus());			        
			        list.add(qa1);
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
