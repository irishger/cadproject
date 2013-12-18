package ie.cit.gerry;

public class User {
	

	private int id;
	private String username;
	
	public User() {
		
	}
	
	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	

}
