package com.krishnan.balaji.web;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/time")
public class TimeServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(res.getOutputStream()));
		for(String s : ZoneId.getAvailableZoneIds()){
			LocalDateTime ldt = LocalDateTime.now(ZoneId.of(s));
			writer.write(String.format("%40s : %20s \n", s,ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"))));
		}
		writer.close();
	}
}