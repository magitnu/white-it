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

public class EntryBean  extends BaseBean{
	public User commentUser;
	public Entry commentEntry;
	public String commentText;
	
	public int voteUp(Entry e) {
		System.out.println("Upvoted"+((Link)e).getTitle());
		return Logic.entry().voteUp(e);
	}
	public int voteDown(Entry e) {
		return Logic.entry().voteDown(e);
	}
	public List<Link> getAllLinks() {
		return Logic.entry().getAllLinks();
	}
	public List<Comment> getCommentsByEntry(Entry entry) {
		return Logic.entry().getCommentsByEntry(entry);
	}
	public int getCommentCountByEntry(Entry entry) {
		return Logic.entry().getCommentsByEntry(entry).size();
	}
	public User getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}
	public Entry getCommentEntry() {
		return commentEntry;
	}
	public void setCommentEntry(Entry commentEntry) {
		this.commentEntry = commentEntry;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Comment rateEntry(Entry ratedEntry, User user, String text) {
		return Logic.entry().rateEntry(ratedEntry, user, text);
	}
	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}
	
	public Comment createComment() {
		System.out.println("inside EntryBean");
		return Logic.entry().createComment(commentUser, commentEntry, commentText);
	}
	
	
	public Link getLinkById() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		return Logic.entity().getLinkById(UUID.fromString(paramMap.get("id")));
	}
	
	public Comment getCommentById() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		return Logic.entity().getCommentById(UUID.fromString(paramMap.get("id")));
	}
}