package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QaDAO {
    public static boolean isQaOK(Qa q) {	  
    	Connection conn = null;
		boolean rs1 = false;
		ResultSet rs = null;
		int rows=0;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        
        String sql1="select * from qa";
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
        
        
        String sql="INSERT INTO qa VALUES (?,?,?,?,?,?,?)";
        int row=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rows+1);
			pstmt.setString(2, q.getSname());
			pstmt.setString(3, q.getTname());
			pstmt.setString(4, q.getContent());
			pstmt.setString(5, q.getTime());
			pstmt.setString(6, null);
			pstmt.setString(7, q.getStatus());			
			
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
    
    
    public static boolean isZoneOK(Zone z) {	  
    	Connection conn = null;
		boolean rs1 = false;
		ResultSet rs = null;
		int rows=0;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        
        String sql1="select * from zone";
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
        
        
        String sql="INSERT INTO zone VALUES (?,?,?,?,?,?)";
        int row=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rows+1);
			pstmt.setString(2, z.getUsername());
			pstmt.setString(3, z.getName());
			pstmt.setString(4, z.getTime());
			pstmt.setString(5, z.getImagePath());
			pstmt.setString(6, z.getContent());						
			
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
    
    
    
    public static boolean isUpdateOK(Qa a){
    	Connection conn = null;
		boolean rs1 = false;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
       
     
        
        String sql="UPDATE qa SET answer = ? , status = ? , time = ? WHERE sname = ? AND tname = ? AND content = ? ";
        int row=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/link?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getAnswer());
			pstmt.setString(2, a.getStatus());
			pstmt.setString(3, a.getTime());
			pstmt.setString(4, a.getSname());
			pstmt.setString(5, a.getTname());
			pstmt.setString(6, a.getContent());
			
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
