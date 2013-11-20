package ch.hsr.intte.whiteit.beans;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryBean extends BaseBean {
	private String commentText;
	private String linkTitle;
	private String linkUrl;

	public void voteUp(String id) {
		Logic.entry().voteUp(Logic.entity().getEntryById(UUID.fromString(id)));
	}

	public void voteDown(String id) {
		Logic.entry().voteDown(Logic.entity().getEntryById(UUID.fromString(id)));
	}

	public List<Link> getAllLinks() {
		return Logic.entry().getAllLinks();
	}

	public List<Comment> getCommentsByEntry(Entry entry) {
		return Logic.entry().getCommentsByEntry(entry);
	}

	public String getCommentCountByEntryId(String id) {
		try {
		return Integer.toString(Logic.entry().getCommentsCountByEntry(Logic.entity().getEntryById(UUID.fromString(id))));
		} catch (Exception e) {
			return "0";
		}
	}

	public void rateEntry() {
		Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		User user = Logic.user().getUserByUsername(paramMap.get("user"));
		Entry ratedEntry = Logic.entity().getEntryById(UUID.fromString(paramMap.get("ratedEntry")));
		Logic.entry().rateEntry(ratedEntry, user, getCommentText());
		commentText = "";
	}

	public String createLink() {
		Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		User user = Logic.user().getUserByUsername(paramMap.get("user"));
		Logic.entry().createLink(user, getLinkUrl(), getLinkTitle());
		linkTitle = "";
		linkUrl = "";
		return "/Whiteit/";
	}
	
	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	
}