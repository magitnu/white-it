package ch.hsr.intte.whiteit.beans;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private User currentUser = null;
	
	public String getName() {
		return currentUser != null ? currentUser.getUsername() : "";
	}

	public boolean login(String username, String password) {
		if(Logic.user().login(username, password)) {
			this.currentUser = Logic.user().getUserByUsername(username);
			return true;
		}
		return false;
	}
	
	
	
	public boolean register(String username, String password) {
		User user = Logic.user().createUser(username, password);
		if(user == null)
			return false;
		
		currentUser = user;
		return true;
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public void logOut() {
		this.currentUser = null;
	}
}
