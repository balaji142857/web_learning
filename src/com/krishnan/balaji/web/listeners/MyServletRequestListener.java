package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
	private static final Logger log = Logger.getLogger(MyServletRequestListener.class.getName());

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		log.info("requestDestroyed called");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		log.info("requestInitialized called");
	}

}
