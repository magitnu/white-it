package ch.hsr.intte.whiteit.beans;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private User currentUser = null;
	public String username;
	public String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return currentUser != null ? currentUser.getUsername() : "";
	}

	public void login() {
		String username = this.username;
		String password = this.password;
		if(Logic.user().login(username, password)) {
			this.currentUser = Logic.user().getUserByUsername(username);
		} 
	}
	
	
	
	public void register() {
		String username = this.username;
		String password = this.password;
		
		currentUser = Logic.user().createUser(username, password);
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public void logOut() {
		this.currentUser = null;
	}
}
