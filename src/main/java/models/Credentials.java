package models;

public class Credentials {

	private String clientId;
	private String username;
	private String password;
	
	public Credentials(String clientId, String username, String password) {
		this.clientId = clientId;
		this.username = username;
		this.password = password;
	}
	
	public String getClintId() {
		return this.clientId;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}
