package ch.hsr.intte.whiteit.beans;

import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.User;

public class SessionBean extends BaseBean {
	private Entry currentEntry;
	private User currentUser;
	
	public Entry getCurrentEntry() {
		return currentEntry;
	}
	public void setCurrentEntry(Entry currentEntry) {
		this.currentEntry = currentEntry;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
