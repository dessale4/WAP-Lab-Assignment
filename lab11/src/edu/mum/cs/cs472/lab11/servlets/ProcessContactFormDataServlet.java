package edu.mum.cs.cs472.lab11.servlets;


import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/ProcessContactFormDataServlet")
public class ProcessContactFormDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int thankYouPageHitCount = 0;
	int contact_form_HitCount = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessContactFormDataServlet() {
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
		// TODO Auto-generated method stub
		contact_form_HitCount++;
		request.setAttribute("contact_form_HitCount", contact_form_HitCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String str ="";
		String name = request.getParameter("fullName");
		if(name.equals("")) {
			str +="Please fillup your full name</br>";
		}
		
		String gender = request.getParameter("customRadioInline1");
		if(gender==null) {
			str +="Please fillup your gender</br>";
		}
		String category = request.getParameter("category");
		if(category.equals("null")) {
			str +="Please provide category</br>";
		}
		
		String message = request.getParameter("message");
		if(message.equals("")) {
			str +="Please provide message</br>";
		}
		if(str.length() == 0) {
			thankYouPageHitCount++;
			String currDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - h:mm:ss a zzzz"));
            request.getServletContext().setAttribute("currDateTime", currDateTime);
			String redirectUrl = "thankyou.jsp?fullName="+name+"&gender="+gender+"&category="+category+"&message="+message+"&thankYouPageHitCount="+thankYouPageHitCount;
            response.sendRedirect(redirectUrl);
		}else {
			contact_form_HitCount++;
			request.setAttribute("contact_form_HitCount", contact_form_HitCount);
			request.setAttribute("errorMessage", true);
			request.setAttribute("error", str);
			RequestDispatcher dispatcher = request.getRequestDispatcher("contact-form.jsp");
			dispatcher.forward(request, response);
		}
	}

}
