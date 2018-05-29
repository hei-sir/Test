package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamDAO {
	 private static String user;
	 public static  String selectUser(String name){
		 Connection conn = null;
			ResultSet rs =null;
			PreparedStatement pstmt=null;	
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user where name = ?";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				
				
				
				rs = pstmt.executeQuery();
				if(rs.first()){
					do{
				user=rs.getString("user");
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
		 return user;
	 }
	
	
	 public static boolean isExamOK(Exam r) {	  
		 System.out.println("Ö´ĞĞst,OK");
	    	Connection conn = null;
			boolean rs1 = false;
			ResultSet rs = null;
			int rows=0;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        
	        String sql1="select * from exam";
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					rows++;
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
	        
	        
	        String sql="INSERT INTO exam VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        int row=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, rows+1);
				pstmt.setInt(2, r.getChinese());
				pstmt.setInt(3, r.getMath());
				pstmt.setInt(4, r.getEnglish());
				pstmt.setInt(5, r.getPolitics());
				pstmt.setInt(6, r.getPhysics());
				pstmt.setInt(7, r.getChemical());
				pstmt.setString(8, r.getExamId());
				pstmt.setString(9, r.getUserId());
				pstmt.setInt(10,r.getScore());
				pstmt.setString(11,r.getRank());	
				pstmt.setString(12,r.getName());
				pstmt.setString(13, r.getTime());
				
				rs1 = pstmt.execute();
				
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
			if(row>0){
				return false;
			}else{
				return true;
			}
	    }
	 
	 public static boolean isSelectNameOk(String name,String school,String grade,String clsses){
	    	Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user where name = ? and school = ? and grade = ? and clsses = ? and identity = ?";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);	
				pstmt.setString(2, school);
				pstmt.setString(3, grade);
				pstmt.setString(4, clsses);
				pstmt.setString(5, "Ñ§Éú");
				
				
				
				
				rs = pstmt.executeQuery();
				while(rs.next()){
					rows++;
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
			if(rows>0){
				return true;
			}else{
				return false;
			}
	    }

}
