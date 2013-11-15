package ch.hsr.intte.whiteit.businesslogic;

import java.io.IOException;

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
	
	public static String getRequestUrl() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(request instanceof HttpServletRequest)
			return ((HttpServletRequest) request).getRequestURL().toString();
		else 
			return "";
	}
	
	public static void addUserMessage(String title, String msg, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, msg));
	}
}
