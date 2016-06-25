package com.brd.business.userinfo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.brd.business.userinfo.domain.UserInfo;

@Component
public class UserInfoDAO {
	public class UserInfoRowMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet rset, int index) throws SQLException {

			UserInfo userInfo = new UserInfo();
			userInfo.setId(rset.getString("id"));
			userInfo.setUsername(rset.getString("username"));
			userInfo.setPassword(rset.getString("password"));
			userInfo.setRealname(rset.getString("realname"));
			return userInfo;
		}
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int inset(UserInfo userInfo) {

		String sql = "INSERT INTO `user_info` (`id`, `username`, `password`, `realname`) VALUES (?, ?, ?, ?);";
		return jdbcTemplate.update(sql, userInfo.getId(), userInfo.getUsername(), userInfo.getPassword(),
				userInfo.getRealname());
	}

	public List<UserInfo> getAllUserInfo() {
		String sql = "select * from user_info order by id";
		return jdbcTemplate.query(sql, new UserInfoRowMapper());
	}

	public UserInfo getUserInfoById(String id) {
		try {
			String sql = "select * from user_info Where id=? order by id";
			return jdbcTemplate.queryForObject(sql, new UserInfoRowMapper(), id);

		} catch (Exception e) {
			return null;
		}
	}

	public UserInfo userLogin(Map<String, Object> params) {
		try {
			String sql = "select * from user_info Where username=?  and password=? ";
			return jdbcTemplate.queryForObject(sql, new UserInfoRowMapper(), params.get("username"),
					params.get("password"));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteAll() {
		String sql = "delete from user_info ";
		return jdbcTemplate.update(sql);
	}

}
