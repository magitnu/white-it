package ch.hsr.intte.whiteit.beans;

import java.util.List;

import ch.hsr.intte.whiteit.businesslogic.Logic;
import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryBean  extends BaseBean{
	public int voteUp(Entry e) {
		return Logic.entry().voteUp(e);
	}
	public int voteDown(Entry e) {
		return Logic.entry().voteDown(e);
	}
	public List<Link> getAllLinks() {
		return Logic.entry().getAllLinks();
	}
	public List<Comment> getCommentsByLink(Link link) {
		return Logic.entry().getCommentsByEntry(link);
	}
	public Comment rateEntry(Entry ratedEntry, User user, String text) {
		return Logic.entry().rateEntry(ratedEntry, user, text);
	}

	public Link createLink(User user, String url, String title) {
		return Logic.entry().createLink(user, url, title);
	}
}
