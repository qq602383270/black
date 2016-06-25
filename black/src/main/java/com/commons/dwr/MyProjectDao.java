package com.commons.dwr;

import java.util.HashMap;
import java.util.Map;

public class MyProjectDao {


	public String getName(String str){
	String returnStr="";

	returnStr="((("+str+"))))MyProjectDao.getName->return String";

	return returnStr;
	}

	public Map getMap(){
	Map<String,String> map=new HashMap<String,String>();
	map.put("1", "v1");
	map.put("2", "v2");
	map.put("3", "v3"); 
	return map;
	}
}
