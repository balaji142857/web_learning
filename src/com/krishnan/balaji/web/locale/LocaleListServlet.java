package com.krishnan.balaji.web.locale;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/locale"})
public class LocaleListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletOutputStream sos = resp.getOutputStream();
		for(Locale l : Locale.getAvailableLocales())
			sos.write(String.format("%s \n", l.toString()).getBytes());
		sos.flush();
		sos.close();
	}
	
	

}
