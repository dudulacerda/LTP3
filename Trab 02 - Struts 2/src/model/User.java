package model;

public class User {
	private String userName;
	private String password;
	
	public User(){
		
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Object user){
		User u = (User) user;
		
		if (u.getUserName().equalsIgnoreCase(this.userName) && u.getPassword().equalsIgnoreCase(this.password)){
			return true;
		} 
		return false;
	}

}
