package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
	private static final Logger log = Logger.getLogger(MyServletRequestAttributeListener.class.getName());

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		log.info("attributeAdded called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		log.info("attributeRemoved called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		log.info("attributeReplaced called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

}
