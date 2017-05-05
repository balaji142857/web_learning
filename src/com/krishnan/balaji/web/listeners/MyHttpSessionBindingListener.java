package com.krishnan.balaji.web.listeners;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
	private static final Logger log = Logger.getLogger(MyHttpSessionBindingListener.class.getName());

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		log.info("valueBound called");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		log.info("valueUnbound called ");
		log.info("arg0.getClass(): " + arg0.getClass() + " arg0.getName():  " + arg0.getName() + " arg0.getValue(): "
				+ arg0.getValue());
	}

}
