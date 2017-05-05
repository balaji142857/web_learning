package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
	private static final Logger log = Logger.getLogger(MyHttpSessionActivationListener.class.getName());

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		log.info("sessionDidActivate called");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		log.info("sessionWillPassivate called");
	}

}
