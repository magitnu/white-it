package ch.hsr.intte.whiteit.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.User;

public class CommentBean extends BaseBean {

	public User user;
	public Entry entry;
	public String text;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void createComment() {
		
	}

}