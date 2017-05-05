package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	private static final Logger log = Logger.getLogger(MyHttpSessionListener.class.getName());

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		log.info("sessionCreated called");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		log.info("sessionDestroyed called");

	}

}
