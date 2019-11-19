package edu.mum.cs.cs472.lab13.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.cs.cs472.lab13.daos.ContactsDAO;
import edu.mum.cs.cs472.lab13.model.ContactFormData;

/**
 * Servlet implementation class ContactFromSearchController
 */
@WebServlet("/ContactFromSearchController")
public class ContactFromSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ContactsDAO contactdao;
    
    public ContactFromSearchController() {
        super();
        contactdao=new ContactsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchby=request.getParameter("SearchBy");
		
		List<ContactFormData> allContactFromDB = contactdao.getAllContactFormData();
	
		 List<ContactFormData> resultContact=allContactFromDB.stream().filter(x->searchby.contains(String.format("%s", x.getContactsId())) || x.getCategory().contains(searchby) || x.getGender().contains(searchby) || x.getMessage().contains(searchby)|| x.getName().contains(searchby)).collect(Collectors.toList());
		
		
		request.setAttribute("contactMessages", resultContact);
		request.getRequestDispatcher("/browse-messages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
