package ch.hsr.intte.whiteit.businesslogic;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class HelperLogic {
	HelperLogic() {}

	public void doPostback() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(request instanceof HttpServletRequest)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(getRequestUrl());
			} catch (IOException e) {}
		}
	}
	public String getRequestUrl()
	{
	    Object requestObject = FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    StringBuilder url = new StringBuilder();
	    try
	    {
	        if(requestObject instanceof HttpServletRequest)
	        {
	        	HttpServletRequest request = (HttpServletRequest) requestObject;
	        	
	            url.append(request.getRequestURL().toString());
	        }
	    }
	    catch(Exception e)
	    {
	    }

	    return url.toString();
	}
	
	public void addUserMessage(String title, String msg, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, msg));
	}
}
