package ch.hsr.intte.whiteit.beans;

import java.io.IOException;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private User currentUser = null;
	private String username;
	private String password;
	private String passwordMatch;
	private Entry currentEntry = null;
	
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
		return getCurrentUser() != null ? getCurrentUser().getUsername() : "";
	}

	public void login() {
		String username = this.username;
		String password = this.password;
		if(Logic.user().login(username, password)) {
			this.setCurrentUser(Logic.user().getUserByUsername(username));
			Logic.helper().doPostback();
			Logic.helper().addUserMessage("Logged in", "User successfully logged in", FacesMessage.SEVERITY_WARN);
		} else {
			Logic.helper().addUserMessage("Couldn't log in", "Username and password did not match", FacesMessage.SEVERITY_WARN);
		}
	}
	
	public void register() {
		String username = this.username;

		if(username == null || username.length() == 0) {
			Logic.helper().addUserMessage("Couldn't register", "No username provided", FacesMessage.SEVERITY_WARN);
			return;
		}
		if(password == null || password.length() == 0) {
			Logic.helper().addUserMessage("Couldn't register", "No password provided", FacesMessage.SEVERITY_WARN);
			return;
		}
		
		String password = this.password;
		String passwordMatch = this.passwordMatch;
		if(password.equals(passwordMatch)) {
			setCurrentUser(Logic.user().createUser(username, password));
			Logic.helper().doPostback();
			Logic.helper().addUserMessage("Registered", "User successfully registered", FacesMessage.SEVERITY_INFO);
		} else {
			Logic.helper().addUserMessage("Couldn't register", "The passwords did not match", FacesMessage.SEVERITY_WARN);
		}
	}
	
	public boolean isLoggedIn() {
		return getCurrentUser() != null;
	}
	
	public void logOut() {
		this.setCurrentUser(null);
		Logic.helper().doPostback();
		Logic.helper().addUserMessage("Logged out", "User successfully logged out", FacesMessage.SEVERITY_INFO);
	}

	public String getPasswordMatch() {
		return passwordMatch;
	}

	public void setPasswordMatch(String passwordMatch) {
		this.passwordMatch = passwordMatch;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Entry getCurrentEntry() {
		return currentEntry;
	}

	public void setCurrentEntry(Entry currentEntry) {
		this.currentEntry = currentEntry;
	}
	
	public void showEntry(String entryId) {
		currentEntry = Logic.entity().getEntryById(UUID.fromString(entryId));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/WhiteIt/faces/linkDetail.xhtml");
		} catch (IOException e) {
		}
	}
}
