package com.krishnan.balaji.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EmailHandlerTag extends SimpleTagSupport {

	private String from;
	private String to;
	private String subject;

	@Override
	public void doTag() throws JspException, IOException {
		String email  = "from: "+from+", to: "+to+", subject: "+subject;
		System.out.println(email);
		StringBuilder op = new StringBuilder();
		op.append("<div style='border:1px solid red'>subject: ").append(subject)
		.append("<br>from: ").append(from)
		.append("<br>to: ").append(to).append("</div>");
		getJspContext().getOut().write(op.toString());
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}