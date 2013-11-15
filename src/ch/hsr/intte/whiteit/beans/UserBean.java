package ch.hsr.intte.whiteit.beans;

import java.io.IOException;
import javax.faces.context.FacesContext;

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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return currentUser != null ? currentUser.getUsername() : "";
	}

	public void login() {
		String username = this.username;
		String password = this.password;
		try {
			if(Logic.user().login(username, password)) {
				this.currentUser = Logic.user().getUserByUsername(username);
				FacesContext.getCurrentInstance().getExternalContext().redirect("/WhiteIt/faces/login.xhtml");
				return;
			} else  {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/WhiteIt/faces/allLinks.xhtml");
			}
		} catch (IOException e) {
		}
	}
	
	
	
	public boolean register() {
		String username = this.username;
		String password = this.password;
		
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
