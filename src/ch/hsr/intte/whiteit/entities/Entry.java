package ch.hsr.intte.whiteit.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Entry extends BaseEntity{
	private Date createdDate;
	private int upVotes;
	private int downVotes;
	private User user;
	private Entry ratesEntry;
	private List<Comment> ratedByComments;

	Entry() {
		super();
		createdDate = new Date();
		upVotes = 0;
		downVotes = 0;
		ratedByComments = new ArrayList<>();
	}

	Entry(Date createdDate, int upVotes, int downVotes, User user, Entry entry) {
		super();
		this.createdDate = createdDate;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.setUser(user);
		this.setRatesEntry(entry);
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public int voteUp() {
		return ++upVotes;
	}

	public int voteDown() {
		return ++downVotes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Entry getRatesEntry() {
		return ratesEntry;
	}

	public void setRatesEntry(Entry ratesEntry) {
		this.ratesEntry = ratesEntry;
	}

	public List<Comment> getRatedByComments() {
		return ratedByComments;
	}

	public void setRatedByComments(List<Comment> ratedBy) {
		this.ratedByComments = ratedBy;
	}
	
	public void addRatedByComment(Comment ratedBy) {
		this.ratedByComments.add(ratedBy);
	}
	
	public void removeRatedByComment(Comment ratedBy) {
		this.ratedByComments.remove(ratedBy);
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
	
}
