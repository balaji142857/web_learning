package com.krishnan.balaji.web.async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = -816247079008052364L;
	
	private static BlockingQueue<AsyncContext> queue = new ArrayBlockingQueue<>(2000);
	private static ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

	static{
		es.scheduleAtFixedRate(AsyncServlet::newEvent, 0, 2, TimeUnit.SECONDS);
		}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		queue.add(req.startAsync());
	}

	private static void newEvent()  {
		ArrayList<AsyncContext> clients = new ArrayList<>(queue.size());
		queue.drainTo(clients);
		clients.parallelStream().forEach((AsyncContext ac) -> {
			ServletOutputStream sos;
			try {
				sos = ac.getResponse().getOutputStream();
				sos.write("Ok".getBytes());sos.flush();sos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ac.complete();
		});
	}
}