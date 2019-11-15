package edu.mum.cs.cs472.lab10.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/ProcessContactFormDataServlet")
public class ProcessContactFormDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		response.sendRedirect("ContactFormServlet");
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
			String redirectUrl = "ThankYouServlet?fullName="+name+"&gender="+gender+"&category="+category+"&message="+message;
            response.sendRedirect(redirectUrl);
		}else {
			request.setAttribute("error", str);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ContactFormServlet");
			dispatcher.forward(request, response);
		}
	}

}
