package com.brd.business.main.dao;

import java.util.ArrayList;
import java.util.List;

import com.brd.business.main.domain.DbUser;

public class UserDao {

	public DbUser getDatabase(String username) {  
		  
        List<DbUser> users = internalDatabase();  
  
        for (DbUser dbUser : users) {  
            if (dbUser.getUsername().equals(username) == true) {  
                return dbUser;  
            }  
        }  
        throw new RuntimeException("User does not exist!");  
  
    }  
  
    /** 
     * 初始化数据 
     */  
    private List<DbUser> internalDatabase() {  
  
        List<DbUser> users = new ArrayList<DbUser>();  
        DbUser user = null;  
  
        user = new DbUser();  
        user.setUsername("admin");  
  
        // "admin"经过MD5加密后  
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");  
        user.setAccess(1);  
  
        users.add(user);  
  
        user = new DbUser();  
        user.setUsername("user");  
  
        // "user"经过MD5加密后  
        user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");  
        user.setAccess(2);  
  
        users.add(user);  
  
        return users;  
  
    }  
}
