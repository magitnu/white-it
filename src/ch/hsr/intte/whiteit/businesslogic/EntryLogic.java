package ch.hsr.intte.whiteit.businesslogic;

import java.util.List;

import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Entry;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntryLogic  extends Logic{
	public int voteUp(Entry e) {
		return e.voteUp();
	}
	public int voteDown(Entry e) {
		return e.voteDown();
	}
	
	public Comment rateEntry(Entry ratedEntry, User user, String text) {
		return createComment(ratedEntry, user, text);
	}

	public Link createLink(User user, String url, String title) {
		Link l = new Link();
		l.setTitle(title);
		l.setUrl(url);
		l.setUser(user);
		Logic.entity().addLink(l);
		return l;
	}
	public Comment createComment(Entry ratedEntry, User user, String text) {
		Comment c = new Comment();
		c.setText(text);
		c.setUser(user);
		c.setRatesEntry(ratedEntry);
		Logic.entity().addComment(c);
		return c;
	}
	
	public List<Link> getAllLinks() {
		return (List<Link>) Logic.entity().getAllLinks();
	}

	public List<Comment> getCommentsByEntry(Entry e) {
		return e.getRatedByComments();
	}
	
	EntryLogic() {}
}
