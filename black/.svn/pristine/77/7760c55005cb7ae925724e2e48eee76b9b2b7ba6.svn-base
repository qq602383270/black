package com.brd.business.userinfolLog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.brd.business.userinfolLog.domain.UserinfoLog;
@Component
public class UserinfoLogDao {

	public class UserinfoLogRowMapper implements RowMapper<UserinfoLog> {

		@Override
		public UserinfoLog mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserinfoLog userinfoLog = new UserinfoLog();
			userinfoLog.setId(rs.getInt("id"));
			userinfoLog.setRealnamel(rs.getString("realname"));
			userinfoLog.setPassword(rs.getString("password"));
			userinfoLog.setUsername("username");
			return userinfoLog;
		}
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insert(UserinfoLog userinfoLog) {
		String sql = "INSERT INTO `user_info_log` (`id`, `username`, `password`, `realname`) VALUES (?, ?, ?, ?);";
		return jdbcTemplate.update(sql, userinfoLog.getId(), userinfoLog.getUsername(), userinfoLog.getPassword(),
				userinfoLog.getRealnamel());
	}
}
