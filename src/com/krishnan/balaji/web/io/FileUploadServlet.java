package com.krishnan.balaji.web.io;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/upload_multiple" })
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	private final static Logger log = Logger.getLogger(FileUploadServlet.class.getCanonicalName());

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// Create path components to save the file
		final String path = request.getParameter("destinationFolder");
				
		Part filePart = null;
		String fileName = null;
		for(int i=1; i< 10;i++){
			log.info("Attempting to get part "+i);
			filePart = request.getPart("uploadedFile"+i);
			if(filePart == null)
			{
				log.info("filePart not found, checking for next file");
				continue;
			}else
				log.info("filePart found, processing the same");
			
			fileName = getFileName(filePart);
			OutputStream out = null;
			InputStream filecontent = null;
			final PrintWriter writer = response.getWriter();

			try {
				out = new FileOutputStream(new File(path + File.separator + fileName));
				filecontent = filePart.getInputStream();

				int read = 0;
				final byte[] bytes = new byte[1024];

				while ((read = filecontent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				writer.println("New file " + fileName + " created at " + path);
				log.log(Level.INFO, "File{0}being uploaded to {1}", new Object[] { fileName, path });
			} catch (FileNotFoundException fne) {
				writer.println("You either did not specify a file to upload or are "
						+ "trying to upload a file to a protected or nonexistent " + "location.");
				writer.println("<br/> ERROR: " + fne.getMessage());

				log.log(Level.SEVERE, "Problems during file upload. Error: {0}", new Object[] { fne.getMessage() });
			} finally {
				if (out != null) {
					out.close();
				}
				if (filecontent != null) {
					filecontent.close();
				}
				if (writer != null) {
					writer.close();
				}
			}
		}
		
	}

	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}