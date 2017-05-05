package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	private static final Logger log = Logger.getLogger(MyServletContextAttributeListener.class.getName());

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		log.info("attributeAdded called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		log.info("attributeRemoved called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		log.info("attributeReplaced called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

}
