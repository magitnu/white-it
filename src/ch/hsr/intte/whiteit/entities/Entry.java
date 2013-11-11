package ch.hsr.intte.whiteit.entities;

import java.util.Date;

public abstract class Entry extends BaseEntity{
	private Date createdDate;
	private int upVotes;
	private int downVotes;
	private User user;
	private Entry belongsTo;

	Entry() {
		super();
		createdDate = new Date();
	}

	Entry(Date createdDate, int upVotes, int downVotes, User user, Entry entry) {
		super();
		this.createdDate = createdDate;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.setUser(user);
		this.setBelongsTo(entry);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + downVotes;
		result = prime * result + upVotes;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (downVotes != other.downVotes)
			return false;
		if (upVotes != other.upVotes)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public Entry getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Entry belongsTo) {
		this.belongsTo = belongsTo;
	}

	
}
