package com.demo;

import java.io.Serializable;
import java.util.Date;

public class User{
	    public static String USER= "user";
	    public static String PASSWORD = "password";
	    public static String STATUS="status";
	    public static String NAME="name";
	    public static String PHONE = "phone";
	    public static String SCHOOL="school";
	    public static String NUMBER="number";
	    public static String IDENTITY="identity";
	    public static String GRADE="grade";
	    public static String CLSSES="clsses";
	    public static String NOTICE="notice";
	    public static String PHOTO="photo";
	    
	  
	    
	    public User(){
	    	super();
	    }
	    private int id;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    private String user;
	    private String password;
	    private String name;
	    private String school;
	    private String number;
	    private String identity;
	    private String grade;
	    private String clsses;
	    private String notice;
	    private String photo;
	    private String phone;
	    
	    public User(int id,String user, String password,String name,String phone,String school,String number,String identity,String grade,String clsses,String notice,String photo){
	      	this.id=id;
	    	this.user=user;
	    	this.password=password;
	    	this.name=name;
	    	this.phone=phone;
	    	this.school=school;
	    	this.number=number;
	    	this.identity=identity;
	    	this.grade=grade;
	    	this.clsses=clsses;
	    	 this.notice = notice;
	    	 this.photo=photo;
	    }
	    
	    public User(String user, String password,String name,String phone,String school,String number,String identity,String grade,String clsses){
	      	this.user=user;
	    	this.password=password;
	    	this.name=name;
	    	this.phone=phone;
	    	this.school=school;
	    	this.number=number;
	    	this.identity=identity;
	    	this.grade=grade;
	    	this.clsses=clsses;
	    }
	    
	    public User(String user, String password){
	      	this.user=user;
	    	this.password=password;
	    }

	    public User(String user,String number,String a ,String b){
	    	this.user=user;
	    	this.number=number;
	    }
	    public User(String user,String number,String password,String a,String b){
	    	this.user=user;
	    	this.number=number;
	    	this.password=password;
	    }
	    public User(String identity,String school,String grade,String clsses,String a,String b,String c){
	    	this.identity=identity;
	    	this.school=school;
	    	this.grade=grade;
	    	this.clsses=clsses;
	    }
	    
	    public User(String user,String notice,String a){
	      	this.user=user;
	    	this.notice=notice;
	    }
	    public String getNotice() {
	        return notice;
	    }

	    public void setNotice(String notice) {
	        this.notice = notice;
	    }
	    
	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    public void setGrade(String grade) {
	        this.grade = grade;
	    }

	    public String getClsses() {
	        return clsses;
	    }

	    public void setClsses(String clsses) {
	        this.clsses = clsses;
	    }

	    public String getUser() {
	        return user;
	    }

	    public void setUser(String user) {
	        this.user = user;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSchool() {
	        return school;
	    }

	    public void setSchool(String school) {
	        this.school = school;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public String getIdentity() {
	        return identity;
	    }

	    public void setIdentity(String identity) {
	        this.identity = identity;
	    }
	    public String getPhoto(){
	    	return photo;
	    }
	    public void setPhoto(String photo){
	    	this.photo=photo;
	    }
}
