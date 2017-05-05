package com.krishnan.balaji.web;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String response = "got get request at " + LocalTime.now();
		System.out.println(response);
		resp.getOutputStream().write(response.getBytes());
		resp.getOutputStream().close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String response = "got post request at " + LocalTime.now();
		System.out.println(response);
		resp.getOutputStream().write(response.getBytes());
		resp.getOutputStream().close();
	}
}
