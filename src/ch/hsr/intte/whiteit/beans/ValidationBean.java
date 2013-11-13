package ch.hsr.intte.whiteit.beans;

import java.net.URI;
import java.util.Map;

import javax.faces.context.FacesContext;

public class ValidationBean extends BaseBean {
	public boolean validateNewComment() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Object commentText = params.get("commentText");
		
		if(commentText == null)
			return false;
		if(!(commentText instanceof String))
			return false;
		if(((String)commentText).isEmpty())
			return false;
		
		return true;
	}
	public boolean validateNewLink() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Object linkText = params.get("linkText");
		Object linkUrl = params.get("linkUrl");
		
		if(linkText == null)
			return false;
		if(!(linkText instanceof String))
			return false;
		if(((String)linkText).isEmpty())
			return false;

		if(linkUrl == null)
			return false;
		if(!(linkUrl instanceof String))
			return false;
		if(((String)linkUrl).isEmpty())
			return false;
		try {
			URI.create((String) linkUrl);
		}catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}
}

