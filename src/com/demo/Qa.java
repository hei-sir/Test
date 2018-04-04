package com.demo;

public class Qa {
	 public static String SNAME= "sname";
	    public static String TNAME= "tname";
	    public static String CONTENT= "content";
	    public static String TIME= "time";
	    public static String ANSWER= "answer";
	    public static String STATUS="status";
	    public static String AAA="aaa";
	
	  private int id;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    private String sname;
	    private String tname;
	    private String content;
	    private String time;
	    private String answer;
	    private String status;

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getAnswer() {
	        return answer;
	    }

	    public void setAnswer(String answer) {
	        this.answer = answer;
	    }

	    public String getSname() {
	        return sname;
	    }

	    public void setSname(String sname) {
	        this.sname = sname;
	    }

	    public String getTname() {
	        return tname;
	    }

	    public void setTname(String tname) {
	        this.tname = tname;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public String getTime() {
	        return time;
	    }

	    public void setTime(String time) {
	        this.time = time;
	    }

	    public Qa(String sname,String tname,String time,String content,String status){	      
	    	this.sname=sname;
	        this.tname=tname;
	        this.time=time;	      
	        this.content=content;
	        this.status=status;
	    }
	    
	    public Qa(String sname,String tname,String time,String content,String answer,String status){	      
	    	this.sname=sname;
	        this.tname=tname;
	        this.time=time;	      
	        this.content=content;
	        this.answer=answer;
	        this.status=status;
	    }

		public Qa() {
			// TODO Auto-generated constructor stub
		}

}
