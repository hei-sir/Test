package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExamAddServlet
 */
@WebServlet("/ExamAddServlet")
public class ExamAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamAddServlet() {
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
        String chinese = request.getParameter(Exam.CHINESE);
        String math = request.getParameter(Exam.MATH);
        String english = request.getParameter(Exam.ENGLISH);
        String physics = request.getParameter(Exam.PHYSICS);
        String chemical = request.getParameter(Exam.CHEMICAL);
        String politics = request.getParameter(Exam.POLITICS);
        String examid = request.getParameter(Exam.EXAMID);
        String userid = request.getParameter(Exam.USERID);
        String name = request.getParameter(Exam.NAME);
        String score = request.getParameter(Exam.SCORE);
        String time = request.getParameter(Exam.TIME);
        String rank = request.getParameter(Exam.RANK);
        String school=request.getParameter(User.SCHOOL);
        String grade=request.getParameter(User.GRADE);
        String clsses=request.getParameter(User.CLSSES);
        Exam r=new Exam(Integer.parseInt(chinese),Integer.parseInt(math),Integer.parseInt(english),Integer.parseInt(politics),Integer.parseInt(chemical),Integer.parseInt(politics),
        		Integer.parseInt(score),examid,ExamDAO.selectUser(name),name,rank,time);
     
        boolean sn =ExamDAO.isSelectNameOk(name,school,grade,clsses);
        System.out.println(name +" "+ ExamDAO.selectUser(name));
        if(sn){      //是否有这个人
        	System.out.println("通过sn,OK");
    	    if(ExamDAO.isExamOK(r)){
    	    	System.out.println("执行st,OK");
    	    	out.println("OK");//成功
    	    }
	    }else{
	    	System.out.println("没通过sn,wrong");
            out.println("Wrong");//该学生不存在
	    }
	}

}
