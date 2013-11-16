package ch.hsr.intte.whiteit.entities;

import java.util.Date;

public class Comment extends Entry {
	private String text;

	public Comment() {
		super();
	}

	public Comment(Date createdDate, int upVotes, int downVotes, User user, Entry entry,
			String text) {
		super(createdDate, upVotes, downVotes, user, entry);
		this.setText(text);
		entry.addRatedByComment((Comment) this);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Comment other = (Comment) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	

}
