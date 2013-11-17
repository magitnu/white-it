package ch.hsr.intte.whiteit.beans;


import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer.Param;

import ch.hsr.intte.whiteit.businesslogic.Helper;
import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

@ApplicationScoped
@ManagedBean
public class EntryBean extends BaseBean {
    @ManagedProperty(value="#{commentBean}")
    private UUID currentLinkId; // +setter
	
	@PostConstruct
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
	
	public UUID getCurrentLinkId() {
		return currentLinkId;
	}

	public void setCurrentLinkId(UUID currentLinkId) {
		System.out.println("Set currentLinkId: " + currentLinkId.toString());
		if (currentLinkId.toString() != null) {
			this.currentLinkId = currentLinkId;
			System.out.println("currentLinkId is set: " + this.currentLinkId.toString());
		} else {
			System.out.println("not set, is still: " + this.currentLinkId.toString());
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
		return Integer.toString(Logic.entry().getCommentsByEntry(getEntryById(id)).size());
	}

	public Comment rateEntry(/*Entry ratedEntry, User user, String text*/) {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		User user = Logic.user().getUserByUsername(paramMap.get("user"));
		Entry ratedEntry = Logic.entity().getEntryById(UUID.fromString(paramMap.get("ratedEntry")));
		return Logic.entry().rateEntry(ratedEntry, user, getCommentText());
	}

	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}

	public void showEntry(String entryId) {
		String uri = Helper.getRequestUrl();
		uri += (uri.contains("?") ? "&" : "?") + "id=" + entryId;
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/WhiteIt/faces/linkDetail.xhtml?id=" + entryId);
		} catch (IOException e) {
		}
	}
	public Link getLinkById() {
		Link l = Logic.entity().getLinkById(getRequestId());
		if (l == null) {
			System.out.println("ReturnedId " + currentLinkId);
			Link ll = (Link) Logic.entity().getEntryById(currentLinkId);
			System.out.println(ll.toString());
			return ll;
		} else {
			return l;
		}
	}

	public Comment getCommentById() {
		return Logic.entity().getCommentById(getRequestId());
	}
	
	public Entry getEntryById(String id) {
		return Logic.entity().getEntryById(getIdFromString(id));
	}
}