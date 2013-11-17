package ch.hsr.intte.whiteit.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

@SessionScoped
public class EntryBean extends BaseBean {
	
	public User commentUser;
	public Entry commentEntry;
	public String commentText;
	
	private UUID getRequestId() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext()
				.getRequestParameterMap();
		return UUID.fromString(paramMap.get("id"));
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
		return Integer.toString(Logic.entry().getCommentsByEntry(getEntryById(id)).size());
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

	
	public void createComment(){
		// Das Problem ist dass der commandButton die Seite aktualisiert und den Parameter ?id=7..... entfernt
		// Ein Redirect mit diesen Parametern angeh�ngt hat leider nicht funktioniert?
		// Habt ihr noch ideen? Ansonsten m�sste man diesen parameter vielleicht in ein Bean speichern statt in der URL....
		
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
		return Logic.entity().getLinkById(getRequestId());
	}

	public Comment getCommentById() {
		return Logic.entity().getCommentById(getRequestId());
	}
	
	public Entry getEntryById(String id) {
		return Logic.entity().getEntryById(getIdFromString(id));
	}
}