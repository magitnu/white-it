package ch.hsr.intte.whiteit.businesslogic;

import ch.hsr.intte.whiteit.entities.User;

public class UserLogic extends Logic {
	UserLogic() {}

	public boolean login(String username, String password) {
		User u = getUserByUsername(username);
		return u == null ? false : u.checkPassword(password);
	}
	
	public User getUserByUsername(String username) {
		for(User u : Logic.entity().getAllUsers()) {
			if(u.getUsername().equalsIgnoreCase(username)) {
				return u;
			}
		}
		return null;
	}
	
	public User createUser(String username, String password) {
		if(getUserByUsername(username) != null) {
			return null;
		}
		User u = new User(username, password);
		Logic.entity().addUser(u);
		return u;
	}
}
