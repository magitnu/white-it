package ch.hsr.intte.whiteit.beans;

import java.util.Map;

import javax.faces.context.FacesContext;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private User currentUser = null;
	
	public String getName() {
		return currentUser != null ? currentUser.getUsername() : "";
	}

	public boolean login(/*String username, String password*/) {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String username = params.get("username");
		String password = params.get("password");

		if(Logic.user().login(username, password)) {
			this.currentUser = Logic.user().getUserByUsername(username);
			return true;
		}
		return false;
	}
	
	
	
	public boolean register(/*String username, String password*/) {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String username = params.get("username");
		String password = params.get("password");
		
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
