package ie.cit.gerry.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.gerry.User;
import ie.cit.gerry.dao.UserDao;
import ie.cit.gerry.dao.mapper.UserMapper;

@Repository
public class JdbcUserDao implements UserDao{
	
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public JdbcUserDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User getCustId(String name) {
		// Get customer ID from username
		String sql = "SELECT * FROM users WHERE username = ?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), name);
		
	}

	@Override
	public User getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User setUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
