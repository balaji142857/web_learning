package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{
	private static final Logger log = Logger.getLogger(MyHttpSessionAttributeListener.class.getName());
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		log.info("attributeAdded called");
		log.info("arg0.getClass(): "+ arg0.getClass() + " arg0.getName():  "+ arg0.getName() + " arg0.getValue(): " + arg0.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		log.info("attributeRemoved called");
		log.info("arg0.getClass(): "+ arg0.getClass() + " arg0.getName():  "+ arg0.getName() + " arg0.getValue(): " + arg0.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		log.info("attributeReplaced called");
		log.info("arg0.getClass(): "+ arg0.getClass() + " arg0.getName():  "+ arg0.getName() + " arg0.getValue(): " + arg0.getValue());
	}

}
