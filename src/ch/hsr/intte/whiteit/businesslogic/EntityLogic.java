package ch.hsr.intte.whiteit.businesslogic;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import ch.hsr.intte.whiteit.entities.Comment;
import ch.hsr.intte.whiteit.entities.Link;
import ch.hsr.intte.whiteit.entities.User;

public class EntityLogic extends Logic {
	private Map<UUID, Comment> comments;
	private Map<UUID, Link> links;
	private Map<UUID, User> users;

	public Collection<Comment> getAllComments() {
		return comments.values();
	}
	public Collection<Link> getAllLinks() {
		return links.values();
	}
	public Collection<User> getAllUsers() {
		return users.values();
	}

	public Comment getCommentById(UUID id) {
		return comments.get(id);
	}
	public Link getLinkById(UUID id) {
		return links.get(id);
	}
	public User getUserById(UUID id) {
		return users.get(id);
	}
	
	EntityLogic() {
		comments = new HashMap<UUID, Comment>();
		links = new HashMap<UUID, Link>();
		users = new HashMap<UUID, User>();
		
		generateMembers();
	}
	
	private void generateMembers() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		try {
			User u1 = new User("mobrist", "abc$123");
			User u2 = new User("mscheub", "abc$123");
			User u3 = new User("fschaef", "abc$123");

			Link l1 = new Link(sdf.parse("02.08.2013 08:15:49"), 15, 24, u1, "This is why I have to miss some school days.", "http://9gag.com/gag/av052Nb");
			Link l2 = new Link(sdf.parse("24.07.2013 16:46:01"), 18, 9, u2, "Now That's What I Call a Sheep Dog!", "http://9gag.com/gag/azbMmzN");
			Link l3 = new Link(sdf.parse("14.09.2013 13:27:33"), 5, 2, u3, "What'd you say to me, b*tch?", "http://9gag.com/gag/ajrm8Zp");

			Comment c1 = new Comment(sdf.parse("04.08.2013 12:52:14"), 4, 2, u1, l1, "Sweet");
			Comment c2 = new Comment(sdf.parse("05.08.2013 12:48:59"), 1, 6, u2, c1, "Dumbass Comment");
			Comment c3 = new Comment(sdf.parse("04.08.2013 15:21:14"), 3, 3, u3, l1, "Always the dogs");

			Comment c4 = new Comment(sdf.parse("25.07.2013 16:46:01"), 2, 4, u1, l2, "Ah dog feeding a lamb");
			Comment c5 = new Comment(sdf.parse("26.07.2013 16:46:01"), 3, 3, u2, l2, "Don't get it");
			Comment c6 = new Comment(sdf.parse("27.07.2013 16:46:01"), 7, 5, u3, c5, "Well, you have no feelings then");

			Comment c7 = new Comment(sdf.parse("14.09.2013 13:27:33"), 9, 7, u1, l3, "A moonwalking cat");
			Comment c9 = new Comment(sdf.parse("14.09.2013 13:27:33"), 7, 3, u3, l3, "I want one too");
			Comment c8 = new Comment(sdf.parse("14.09.2013 13:27:33"), 2, 6, u2, c9, "Get to the pet store");

			users.put(u1.getId(), u1);
			users.put(u2.getId(), u2);
			users.put(u3.getId(), u3);

			links.put(l1.getId(), l1);
			links.put(l2.getId(), l2);
			links.put(l3.getId(), l3);

			comments.put(c1.getId(), c1);
			comments.put(c2.getId(), c2);
			comments.put(c3.getId(), c3);
			comments.put(c4.getId(), c4);
			comments.put(c5.getId(), c5);
			comments.put(c6.getId(), c6);
			comments.put(c7.getId(), c7);
			comments.put(c8.getId(), c8);
			comments.put(c9.getId(), c9);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
