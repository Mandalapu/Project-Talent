package com.example.projecttalentoriginal;



import android.app.Application;
public class MyGlobalVariables extends Application {
	    private static String userName;
	    private static int age;
	    private static String data="";
	    private static int missitem=0;
	    private static String t="";

		public static int repeatNo;
		public static int q31,q32,q33,qx1,qx2,qx3;
	    public static int getAge() { return age; }
	    
	    public static int getMissItem() { return missitem; }

	    public static String getUserName(){
	        return userName;
	    }
	    public static String getData() {
	    	return data;
	    }
	    public static String getTime() {
	    	return t;
	    }
	    public static void setAge(int a) { age = a; }

	    public static void setUserName(String uName){
	        userName = uName;
	    }
	    public static void setData(String d) {
	    	data = d;
	    }
	    public static void setTime(String ti) {
	    	t = ti;
	    }
	    public static void setMissItem(int m) { missitem = m; }
	}
