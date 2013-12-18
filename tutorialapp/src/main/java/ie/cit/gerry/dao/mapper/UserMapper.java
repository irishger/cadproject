package ie.cit.gerry.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.gerry.User;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int i) throws SQLException {
		User ur = new User();
		ur.setId(rs.getInt("id"));
		ur.setUserName(rs.getString("username"));

		return ur;
	}

}