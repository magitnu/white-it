package ch.hsr.intte.whiteit.beans;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;

import ch.hsr.intte.whiteit.businesslogic.Helper;
import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryBean extends BaseBean {
	private String commentText;
	
	private UUID getRequestId() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext()
				.getRequestParameterMap();
		if (paramMap.containsKey("id")) {
			return UUID.fromString(paramMap.get("id"));
		} else {
			return null;
		}
	}
	
	private UUID getIdFromString(String id){
		return UUID.fromString(id);
	}
	
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
		return Integer.toString(Logic.entry().getCommentsCountByEntry(getEntryById(id)));
	}

	public String rateEntry() {
		Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		User user = Logic.user().getUserByUsername(paramMap.get("user"));
		Entry ratedEntry = Logic.entity().getEntryById(UUID.fromString(paramMap.get("ratedEntry")));
		Logic.entry().rateEntry(ratedEntry, user, getCommentText());
		Helper.doPostback();
		return "";
	}

	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}
	
	public Comment getCommentById() {
		return Logic.entity().getCommentById(getRequestId());
	}
	
	public Entry getEntryById(String id) {
		return Logic.entity().getEntryById(getIdFromString(id));
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
}