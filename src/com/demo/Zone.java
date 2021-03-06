package com.demo;

public class Zone {
	
	public static String USERNAME= "username";
	public static String NAME="name";
	public static String Time= "time";
	public static String CONTENT="content";
	public static String AAA="aaa";
	public static String IMAGEPATH="imagePath";
	public static String IMAGE="image";
	
	private int id;
    private String username;
    private String name;
    private String time;
    private String content;
    private int imageId;
    private String imagePath;
    private byte[] image;

    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    
    public Zone(){
       
    }
    public Zone(String username,String name,String time,String content,String imagePath){
        this.username=username;
        this.name=name;
        this.time=time;
        this.content=content;
        this.imagePath=imagePath;
    }

    public Zone(String username,String name,String time,String content,int imageId,String imagePath){
        this.username=username;
        this.name=name;
        this.time=time;
        this.content=content;
        this.imageId=imageId;
        this.imagePath=imagePath;
    }
}
