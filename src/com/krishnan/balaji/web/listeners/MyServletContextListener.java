package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(MyServletContextListener.class.getName());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("contextDestroyed called");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("contextInitialized called");
	}
}