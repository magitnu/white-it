package ch.hsr.intte.whiteit.beans;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import ch.hsr.intte.whiteit.businesslogic.Helper;
import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryBean  extends BaseBean{
	public User commentUser;
	public String commentEntryId;
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
	public String getCommentEntryId() {
		return commentEntryId;
	}
	public void setCommentEntryId(String commentEntryId) {
		this.commentEntryId = commentEntryId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Comment rateEntry() {
		//Entry ratedEntry, User user, String text
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		return null;//Logic.entry().rateEntry(ratedEntry, user, text);
	}
	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}
	
	
	public void createComment(){
		// Das Problem ist dass der commandButton die Seite aktualisiert und den Parameter ?id=7..... entfernt
		// Ein Redirect mit diesen Parametern angehängt hat leider nicht funktioniert?
		// Habt ihr noch ideen? Ansonsten müsste man diesen parameter vielleicht in ein Bean speichern statt in der URL....
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		
		System.out.println(paramMap.get("currentEntry"));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("www.google.com");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		  System.out.println(commentEntryId);
//		  Helper.doPostback();
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