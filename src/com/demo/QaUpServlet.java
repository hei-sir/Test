package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QaUpServlet
 */
@WebServlet("/QaUpServlet")
public class QaUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaUpServlet() {
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
        String sname = request.getParameter(Qa.SNAME);
        String tname=request.getParameter(Qa.TNAME);
        String answer=request.getParameter(Qa.ANSWER);
        String time=request.getParameter(Qa.TIME);
        String content=request.getParameter(Qa.CONTENT);
        String status=request.getParameter(Qa.STATUS);
        String aaa=request.getParameter(Qa.AAA);
        String name = request.getParameter(Zone.NAME);
        String username = request.getParameter(Zone.USERNAME);
        String imagePath=request.getParameter(Zone.IMAGEPATH);
        String image=request.getParameter(Zone.IMAGE);
        Zone z=new Zone(username,name,time,content,imagePath);
        Qa q= new Qa(sname,tname,time,content,status);
        Qa a=new Qa(sname,tname,time,content,answer,status);
        if(aaa.equals("0")){
    		boolean st = QaDAO.isQaOK(q);                      //家长新建问题
            if(st){
            	out.println("OK");
    		}else{
                out.println("Wrong");
                }            
            }else if (aaa.equals("1")){                    //教师更新答案
            	boolean st = QaDAO.isUpdateOK(a);        
                if(st){
                	out.println("OK");
        		}else{
                    out.println("Wrong");
                    }
            }else if(aaa.equals("2")){              //Zone新建说说
            	boolean st = QaDAO.isZoneOK(z);        
                if(st){
                	out.println("OK");
        		}else{
                    out.println("Wrong");
                    }
            }
        }

}
