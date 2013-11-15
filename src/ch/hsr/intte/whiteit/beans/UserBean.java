package ch.hsr.intte.whiteit.beans;

import javax.faces.application.FacesMessage;

import ch.hsr.intte.whiteit.businesslogic.Helper;
import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private User currentUser = null;
	public String username;
	public String password;
	private String passwordMatch;
	
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
			Helper.doPostback();
			Helper.addUserMessage("Logged in", "User successfully logged in", FacesMessage.SEVERITY_WARN);
		} else {
			Helper.addUserMessage("Couldn't log in", "Username and password did not match", FacesMessage.SEVERITY_WARN);
		}
	}
	
	
	
	public void register() {
		String username = this.username;

		if(username == null || username.length() == 0) {
			Helper.addUserMessage("Couldn't register", "No username provided", FacesMessage.SEVERITY_WARN);
			return;
		}
		if(password == null || password.length() == 0) {
			Helper.addUserMessage("Couldn't register", "No password provided", FacesMessage.SEVERITY_WARN);
			return;
		}
		
		String password = this.password;
		String passwordMatch = this.passwordMatch;
		if(password.equals(passwordMatch)) {
			currentUser = Logic.user().createUser(username, password);
			Helper.doPostback();
			Helper.addUserMessage("Registered", "User successfully registered", FacesMessage.SEVERITY_INFO);
		} else {
			Helper.addUserMessage("Couldn't register", "The passwords did not match", FacesMessage.SEVERITY_WARN);
		}
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public void logOut() {
		this.currentUser = null;
		Helper.doPostback();
		Helper.addUserMessage("Logged out", "User successfully logged out", FacesMessage.SEVERITY_INFO);
	}

	public String getPasswordMatch() {
		return passwordMatch;
	}

	public void setPasswordMatch(String passwordMatch) {
		this.passwordMatch = passwordMatch;
	}
}
