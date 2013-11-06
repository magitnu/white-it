package ch.hsr.intte.whiteit.beans;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.User;

public class UserBean extends BaseBean {
	private String username;
	private String password;

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPasswort() {
		return password;
	}

	public void setPasswort(String passwort) {
		this.password = passwort;
	}
	
	public boolean login(String username, String password) {
		this.username = username;
		this.password = password;
		return Logic.user().login(this.username, this.password);
	}
	
	public User register(String username, String password) {
		return Logic.user().register(username, password);
	}
}
