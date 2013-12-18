package ie.cit.gerry.dao;

import ie.cit.gerry.User;

public interface UserDao {
	
	User getCustId(String name);
	
	User getUserName();
	User setUserName(String name);
}
