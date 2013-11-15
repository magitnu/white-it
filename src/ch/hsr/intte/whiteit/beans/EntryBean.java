package ch.hsr.intte.whiteit.beans;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryBean  extends BaseBean{
	
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
	public Comment rateEntry(Entry ratedEntry, User user, String text) {
		return Logic.entry().rateEntry(ratedEntry, user, text);
	}
	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}
}