package com.brd.business.userinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.brd.business.userinfo.dao.UserInfoDAO;
import com.brd.business.userinfo.domain.UserInfo;
import com.brd.business.userinfo.mapper.UserInfoMapper;
import com.brd.business.userinfo.service.UserInfoService;
import com.brd.business.userinfolLog.dao.UserinfoLogDao;
import com.brd.business.userinfolLog.domain.UserinfoLog;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	UserInfoDAO userInfoDAO;
	@Autowired
	UserinfoLogDao userinfoLogDao;

	@Override
	public List<Map<String, Object>> selectCityList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectCityList(params);
	}
	@Override
	public List<UserInfo> getAllUserInfo_DAO() {
		// TODO Auto-generated method stub
		return userInfoDAO.getAllUserInfo();
	}
	@Override
	public int inset_DAO(UserInfo userInfo) {
		int count=userInfoDAO.inset(userInfo);
		UserinfoLog  userinfoLog=new UserinfoLog();
		try {
			BeanUtils.copyProperties(userinfoLog, userInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userinfoLogDao.insert(userinfoLog);
		
		// TODO Auto-generated method stub
		return count;
	}
	@Override
	@Cacheable(value = "userCache", key = "#id")
	public UserInfo getUserInfoById_DAO(String  id) {
		UserInfo userInfo=userInfoDAO.getUserInfoById(id);
		// TODO Auto-generated method stub
		return userInfo;
	}
	@Override
	public UserInfo userLogin(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userInfoDAO.userLogin(params);
	}
	@Override
	public int findAll() {
		return userInfoDAO.deleteAll();
		
	}
	@Override
	@CacheEvict(value="userCache",key="#id")
	public int deleteUserById(String id) {
		return 0;
		
	}


}
