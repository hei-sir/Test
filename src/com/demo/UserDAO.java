package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class UserDAO {

	 
	    //ÑéÖ¤º¯Êı
	    public static boolean isLoginOK(User u) {	  
	    	Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user where user = ? and password = ?";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, u.getUser());
				pstmt.setString(2, u.getPassword());
				
				
				
				
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
	    
	    public static boolean isSelectUserOk(String userid){
	    	Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user where user = ?";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userid);		
				
				
				
				
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
	    
	    public static boolean isSelectNumberOk(User p){
	    	Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        String sql="select * from user where user = ? and number=?";
	        int rows=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, p.getUser());		
				pstmt.setString(2, p.getNumber());
				
				
				
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
	    
	    public static boolean isNoticeOK(User n){
	    	Connection conn = null;
			boolean rs1 = false;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	       
	     
	        
	        String sql="UPDATE user SET notice = ? WHERE user = ? ";
	        int row=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, n.getNotice());
				pstmt.setString(2, n.getUser());
				
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
	    
	    public static boolean isPasswordOk(User w){
	    	Connection conn = null;
			boolean rs1 = false;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	       
	     
	        
	        String sql="UPDATE user SET password = ? WHERE user = ? and number = ? ";
	        int row=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, w.getPassword());
				pstmt.setString(2, w.getUser());
				pstmt.setString(3, w.getNumber());
				
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
	    
	    
	    
	    
	    
	    public static boolean isRegisterOK(User r) {	  
	    	Connection conn = null;
			boolean rs1 = false;
			ResultSet rs = null;
			int rows=0;
			PreparedStatement pstmt=null;
	        String driver="com.mysql.jdbc.Driver";
	        
	        String sql1="select * from user";
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
	        
	        
	        String sql="INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	        int row=0;
	        try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
					                                   "user=root&password=");
				//3.3 
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, rows+1);
				pstmt.setString(2, r.getUser());
				pstmt.setString(3, r.getPassword());
				pstmt.setString(4, r.getName());
				pstmt.setString(5, r.getSchool());
				pstmt.setString(6, r.getNumber());
				pstmt.setString(7, r.getIdentity());
				pstmt.setString(8, r.getGrade());
				pstmt.setString(9, r.getClsses());
				pstmt.setString(10,null);
				pstmt.setString(11,null);			
				
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

}
