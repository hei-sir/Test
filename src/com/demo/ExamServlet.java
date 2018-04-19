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
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Exam> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
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
	         
	         for(Exam bean: list)
	        {
	            JSONObject obj=new JSONObject();
	             
	             try{
	            	 
	                 obj.put("id",bean.getId() );
	                 obj.put("chinese", bean.getChinese());
	                 obj.put("math", bean.getMath());
	            	 obj.put("english", bean.getEnglish());
	                 obj.put("politics", bean.getPolitics());
	                 obj.put("physics", bean.getPhysics());
	                 obj.put("chemical", bean.getChemical());	
	                 System.out.println(bean.getName());
	                 obj.put("examId", bean.getExamId());
	                 obj.put("userId", bean.getUserId());
	                 obj.put("score", bean.getScore());
	                 obj.put("rank", bean.getRank());
	                 obj.put("name", bean.getName());
	                 obj.put("time", bean.getTime());
	                 
	                 
	             }
	             catch(Exception e){
	                 
	            }
	             
	            
	         array.add(obj);
	            
	             
	         }
	         out.write(array.toString());
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
	
	private List<Exam> PrapareData()
    {
	Exam u=new Exam();
  	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt=null;
    String driver="com.mysql.jdbc.Driver";
    String sql="select * from exam";
   int rows=0;
   try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
			                                   "user=root&password=");
		//3.3 
		
		pstmt=conn.prepareStatement(sql);
		
		
		
		
		rs = pstmt.executeQuery();
		list=new ArrayList<Exam>();
		if(rs.first()){
			do{
				u.setId(rs.getInt("id") );
				u.setChinese(rs.getInt("chinese"));
				u.setMath(rs.getInt("math"));
				u.setEnglish(rs.getInt("english"));
				u.setPolitics(rs.getInt("politics"));
				u.setPhysics(rs.getInt("physics"));
				u.setChemical(rs.getInt("chemical"));	  
				u.setExamId(rs.getString("examId"));
				u.setUserId(rs.getString("userId"));
				u.setScore(rs.getInt("score"));
				u.setRank(rs.getString("rank"));
				u.setName(rs.getString("name"));
				u.setTime(rs.getString("time"));
			
			    Exam e=new Exam();
			    e.setId(u.getId());
			    e.setChinese(u.getChinese());
			    e.setMath(u.getMath());
		        e.setEnglish(u.getEnglish());
		        e.setPolitics(u.getPolitics());
		        e.setPhysics(u.getPhysics());
		        e.setChemical(u.getChemical());
		        e.setExamId(u.getExamId());
		        e.setUserId(u.getUserId());
		        e.setScore(u.getScore());
		        e.setRank(u.getRank());
		        e.setName(u.getName());
		        e.setTime(u.getTime());
		        list.add(e);
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
