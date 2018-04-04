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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
        out.println("GET");
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //取出URL中的账号密码参数
        String user = request.getParameter(User.USER);
        String password = request.getParameter(User.PASSWORD);
        String status=request.getParameter(User.STATUS);
        String name=request.getParameter(User.NAME);
	    String school=request.getParameter(User.SCHOOL);
	    String number=request.getParameter(User.NUMBER);
	    String identity=request.getParameter(User.IDENTITY);
	    String grade=request.getParameter(User.GRADE);
	    String notice=request.getParameter(User.NOTICE);
	    String clsses=request.getParameter(User.CLSSES);
        User u=new User(user,password);
        User r=new User(user,password,name,school,number,identity,grade,clsses);
        User n=new User(user,notice,"1");
        if(status.equals("1")){
		boolean st = UserDAO.isLoginOK(u);        
        if(st){
        	out.println("OK");
		}else{
            out.println("Wrong");
        }
        }else if(status.equals("0")){
        	boolean st = UserDAO.isRegisterOK(r);        
            if(st){
            	out.println("OK");
    		}else{
                out.println("Wrong");
            }
        }else if(status.equals("2")){
        	boolean st = UserDAO.isNoticeOK(n);        
            if(st){
            	out.println("OK");
    		}else{
                out.println("Wrong");
            }
        }

        out.flush();
        out.close();
	}
	
}
