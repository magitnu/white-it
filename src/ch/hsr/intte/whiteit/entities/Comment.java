package ch.hsr.intte.whiteit.entities;

import java.util.Date;

public class Comment extends Entry {
	private String text;

	public Comment() {
		super();
	}

	public Comment(Date createdDate, int upVotes, int downVotes, User user,
			String text) {
		super(createdDate, upVotes, downVotes, user);
		this.setText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
