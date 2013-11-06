package ch.hsr.intte.whiteit.entities;

import java.util.Date;

public abstract class Entry extends BaseEntity{
	private Date createdDate;
	private int upVotes;
	private int downVotes;
	private User user;

	Entry() {
		super();
		createdDate = new Date();
	}

	Entry(Date createdDate, int upVotes, int downVotes, User user) {
		super();
		this.createdDate = createdDate;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.setUser(user);
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getPlusVotes() {
		return upVotes;
	}

	public void setPlusVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getMinusVotes() {
		return downVotes;
	}

	public void setMinusVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public int upVote() {
		return ++upVotes;
	}

	public int downVote() {
		return ++downVotes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
