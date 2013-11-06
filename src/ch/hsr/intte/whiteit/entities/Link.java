package ch.hsr.intte.whiteit.entities;

import java.util.Date;

public class Link extends Entry {
	private String title;
	private String url;

	public Link() {
		super();
	}

	public Link(Date createdDate, int upVotes, int downVotes, User user,
			String title, String url) {
		super(createdDate, upVotes, downVotes, user);
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
