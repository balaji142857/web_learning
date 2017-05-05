package com.krishnan.balaji.web.locale;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/i18n" })
public class InternationalizationServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(InternationalizationServlet.class.getName());

	ResourceBundle rb = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/i18n.jsp");
		Locale locale = req.getLocale();
		log.info("request locale is " + locale);
		rb = ResourceBundle.getBundle("com.krishnan.balaji.web.locale.messages", locale);
		String hello = rb.getString("hello");
		log.info("obtained the string hello for locale: " + locale + " as " + hello);
		req.setAttribute("hello", hello);
		rd.forward(req, resp);
	}
}