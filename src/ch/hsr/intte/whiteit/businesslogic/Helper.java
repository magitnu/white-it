package ch.hsr.intte.whiteit.businesslogic;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Helper {
	public static void doPostback() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(request instanceof HttpServletRequest)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(getRequestUrl());
			} catch (IOException e) {}
		}
	}
	public static String getRequestUrl()
	{
	    Object requestObject = FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    StringBuilder url = new StringBuilder();
	    try
	    {
	        if(requestObject instanceof HttpServletRequest)
	        {
	        	HttpServletRequest request = (HttpServletRequest) requestObject;
	        	
	            url.append(request.getRequestURL().toString());
	            /*String id = request.getParameter("id");

	            if(id!=null && id.length() != 0)
                    url.append((!url.toString().contains("?") ? "?" : "&") + id);*/
	        }
	    }
	    catch(Exception e)
	    {
	    }

	    return url.toString();
	}
	
	public static void addUserMessage(String title, String msg, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, msg));
	}
}
