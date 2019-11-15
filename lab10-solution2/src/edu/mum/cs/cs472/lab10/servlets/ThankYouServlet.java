package edu.mum.cs.cs472.lab10.servlets;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/ThankYouServlet")
public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       private int hitCount = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThankYouServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hitCount++;
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		String message = request.getParameter("message");
		Object objTotalHitCount = request.getServletContext().getAttribute("totalHitCount");
        String totalHitCount = ((Integer)objTotalHitCount).toString();
		StringBuilder sb = new StringBuilder();
		LocalDate date = LocalDate.now();
		sb.append("<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" + 
				"        integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" + 
				"    <title>Student Registration Form</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"    <nav class=\"navbar navbar-expand-lg navbar-light bg-info\">\n" + 
				"        <a class=\"navbar-brand\" href=\"#\">CS472:::Lab10</a>\n" + 
				"    </nav>\n" + 
				"\n" + 
				"    <p> <span class = \"float-right\"> " +date + " </span></p>\n" + 
				"    <div class = \"container\">\n" + 
				"        <div class=\"list-group\">\n" + 
				"            <a href=\"#\" class=\"list-group-item active disabled\">\n" + 
				"                Thank you! Your message has been recieved as follows:\n" + 
				"            </a>\n" + 
				"            <a href=\"#\" class=\"list-group-item list-group-item-action disabled\">Name: " + fullName +" </a>\n" + 
				"            <a href=\"#\" class=\"list-group-item list-group-item-action disabled\">Gender: " + gender + " </a>\n" + 
				"            <a href=\"#\" class=\"list-group-item list-group-item-action disabled\">Category: " + category + " </a>\n" + 
				"            <a href=\"#\" class=\"list-group-item list-group-item-action disabled\">Message: " + message + " </a>\n" + 
				"            <a href=\"ContactFormServlet\" class=\"list-group-item list-group-item-action \">Please feel free to Contact US again</a>\n" + 
				"        </div>\n" + 
				"        <footer>Hit count for this page:  "+ hitCount + " <span class = \"float-right\">Total hit count for the entire WebApp: " + totalHitCount + " </span></footer>\n" + 
				"    </div>\n" + 
				"</body>\n" + 
				"</html>");
		response.getWriter().append(sb);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
