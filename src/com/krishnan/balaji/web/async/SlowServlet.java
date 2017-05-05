package com.krishnan.balaji.web.async;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/slow")
public class SlowServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int sleepTime = 3;
		StringBuilder status = new StringBuilder("starting.. ");
		String delay = req.getParameter("delay");
		status.append("requested delay parameter is "+delay+" minutes.\n");
		
		
		if (null != delay && delay.length() > 0) {
			int temp = Integer.parseInt(delay);
			if(temp >0 && temp < 10){
				sleepTime=temp;
				status.append("accepted the requested delay parameter");
			}else
				status.append("using preset delay parameter of "+ sleepTime+" minutes as requested value is not between 0 and 10 minutes. \n");
		}
		else
			status.append("using preset delay parameter of "+ sleepTime+" minutes as requested value either null or empty string. \n");
		
		try {
			status.append("attempting to sleep for "+sleepTime+" minutes\n");
			TimeUnit.MINUTES.sleep(sleepTime);
			status.append("waking up after sleep... \n");
		} catch (InterruptedException e) {
			status.append("sleep interrupted with message" + e.getMessage()+" \n");
			e.printStackTrace();
		}
		System.out.println(status.toString());
		resp.getOutputStream().write(status.toString().getBytes());
		resp.getOutputStream().flush();
		resp.getOutputStream().close();			
	}

}