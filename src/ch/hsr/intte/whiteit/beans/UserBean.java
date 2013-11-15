package ch.hsr.intte.whiteit.beans;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
		} 
	}
	
	
	
	public void register() {
		String username = this.username;
		String password = this.password;
		String passwordMatch = this.passwordMatch;
		if(password.equals(passwordMatch)) {
			currentUser = Logic.user().createUser(username, password);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(getRequestUri());
			} catch (IOException e) {}
		}
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public void logOut() {
		this.currentUser = null;
	}

	public String getPasswordMatch() {
		return passwordMatch;
	}

	public void setPasswordMatch(String passwordMatch) {
		this.passwordMatch = passwordMatch;
	}
	
	private String getRequestUri() {
	    Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    if(request instanceof HttpServletRequest)
	    {
	            return ((HttpServletRequest) request).getRequestURL().toString();
	    }else
	    {
	        return "";
	    }
	}
}
