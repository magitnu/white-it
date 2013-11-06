package ch.hsr.intte.whiteit.businesslogic;

import ch.hsr.intte.whiteit.entities.User;

public class UserLogic extends Logic {
	UserLogic() {}

	public boolean login(String username, String password) {
		return true;
	}
	
	public User register(String username, String password) {
		return null;
		//TODO: create user
		//return new User()
	}
}
