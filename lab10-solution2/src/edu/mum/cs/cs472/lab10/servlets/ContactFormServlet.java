package edu.mum.cs.cs472.lab10.servlets;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactFormServlet")
public class ContactFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		hitCount++;
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

		hitCount ++;
		
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		String message = request.getParameter("message");
		Object objTotalHitCount = request.getServletContext().getAttribute("totalHitCount");
        String totalHitCount = ((Integer)objTotalHitCount).toString();
		StringBuilder sb = new StringBuilder();
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
				"\n" + 
				"<body>\n" + 
				"    <nav class=\"navbar navbar-expand-lg navbar-light bg-info\">\n" + 
				"        <a class=\"navbar-brand\" href=\"#\">CS472-WAP:::Lab10</a>\n" + 
				"        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" + 
				"            <span class=\"navbar-toggler-icon\"></span>\n" + 
				"        </button>\n" + 
				"        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" + 
				"            <ul class=\"navbar-nav mr-auto\">\n" + 
				"            <li class=\"nav-item active\">\n" + 
				"                <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" + 
				"            </li>\n" + 
				"            <li class=\"nav-item active\">\n" + 
				"                <a class=\"nav-link\" href=\"#\">About <span class=\"sr-only\">(current)</span></a>\n" + 
				"            </li>\n" + 
				"            <li class=\"nav-item active\">\n" + 
				"                <a class=\"nav-link\" href=\"ContactFormServlet\">Contact Us <span class=\"sr-only\">(current)</span></a>\n" + 
				"            </li>\n" + 
				"            \n" + 
				"            </ul>\n" + 
				"            <ul class=\"navbar-nav mr-auto float-right\">\n" + 
				"                <li class=\"nav-item\">\n" + 
				"                    <a class=\"nav-link active\" href=\"#\">Welcome</a>\n" + 
				"                </li>\n" + 
				"                \n" + 
				"                <li class=\"nav-item\">\n" + 
				"                    <button type=\"button\" class=\"btn btn-primary\">Sign Out</button>\n" + 
				"                </li>\n" + 
				"            </ul>\n" + 
				"        </div>\n" + 
				"    </nav>\n" + 
				"    <div class=\"container\">\n" + 
				"        <span style=\"font-size: 35px; font-weight: 10px;\">Customer Contact Form</span>\n");
				Object errorFound = request.getAttribute("error");
				if(errorFound != null) {
					String foundError = (String)errorFound;
					sb.append("<div><p class = \"text-danger\">");
		            sb.append(foundError);
		            sb.append("</p ></div>");
				}		
			sb.append("<form  action = \"ProcessContactFormDataServlet\" method = \"post\"> \n");

			 sb.append("<div class=\"form-group\">");
		        sb.append("<label for=\"customerName\">*Name:</label>");
		        if(fullName != null) {
		            if(fullName.equals("")) {
		                sb.append("<input type=\"text\" class=\"form-control\" id=\"fullName\" name=\"fullName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
		            } else {
		                sb.append("<input type=\"text\" class=\"form-control\" id=\"fullName\" name=\"fullName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" value=\'" + fullName + "'>");
		            }
		        } else {
		            sb.append("<input type=\"text\" class=\"form-control\" id=\"fullName\" name=\"fullName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
		        }
		        sb.append("<small id=\"fullNameHelp\" class=\"form-text text-muted\">Enter your full name.</small>");
		        sb.append("</div>");
		        
		        sb.append("<div class = \"form-group\">\n" + 
						"                    <label for=\"fullName\">*Gender:</label>\n" + "<br/> "+
						"           <div class=\"custom-control custom-radio custom-control-inline\">\n" + 
						"                <input type=\"radio\" id=\"customRadioInline1\" name=\"customRadioInline1\" class=\"custom-control-input\" value=\"male\">\n" + 
						"                <label class=\"custom-control-label\" for=\"customRadioInline1\">Male</label>\n" + 
						"            </div>\n" + 
						"            \n" + 
						"            <div class=\"custom-control custom-radio custom-control-inline\">\n" + 
						"                <input type=\"radio\" id=\"customRadioInline2\" name=\"customRadioInline1\" class=\"custom-control-input\" value=\"female\">\n" + 
						"                <label class=\"custom-control-label\" for=\"customRadioInline2\">Female</label>\n" + 
						"            </div>\n"+ 
						"            </div>\n"); 
		        
//		        //==================
//		        sb.append("<label>*Gender:</label><br/>");
//		        sb.append("<label class=\"custom-control custom-radio\">");
//		        sb.append("  <input id=\"radioGenderMale\" name=\"gender\" type=\"radio\" class=\"custom-control-input\" value='male'");
//		        if(gender != null) {
//		            if(gender.equals("male")) {
//		                sb.append(" checked>");
//		            }
//		            else {
//		                sb.append(">");
//		            }
//		        } else {
//		            sb.append("  <input id=\"radioGenderMale\" name=\"gender\" type=\"radio\" class=\"custom-control-input\" value='male'>");
//		        }
//		        sb.append("  <span class=\"custom-control-indicator\"></span>");
//		        sb.append("  <span class=\"custom-control-description\">Male</span>");
//		        sb.append("</label>");
//		        sb.append("<label class=\"custom-control custom-radio\">");
//		        sb.append("  <input id=\"radioGenderFemale\" name=\"gender\" type=\"radio\" class=\"custom-control-input\" value='female'");
//		        if(gender != null) {
//		            if(gender.equals("female")) {
//		                sb.append(" checked>");
//		            } else {
//		                sb.append(">");
//		            }
//		        } else {
//		            sb.append("  <input id=\"radioGenderFemale\" name=\"gender\" type=\"radio\" class=\"custom-control-input\" value='female'>");
//		        }
//		        sb.append("  <span class=\"custom-control-indicator\"></span>");
//		        sb.append("  <span class=\"custom-control-description\">Female</span>");
//		        sb.append("</label>");
//		        //=====================
		        
				sb.append("<div class=\"form-group\">");
		        sb.append("    <label for=\"category\">*Category:</label>");
		        sb.append("    <select class=\"form-control\" id=\"category\" name=\"category\">");
		        if(category == null) {
		            sb.append("      <option value=\"null\">Select...</option>");
		            sb.append("      <option value=\"feedback\">Feedback</option>");
		            sb.append("      <option value=\"inquiry\">Inquiry</option>");
		            sb.append("      <option value=\"complaint\">Complaint</option>");
		        } else {
		            switch (category) {
		                case "null":
		                    sb.append("      <option selected value=\"null\">Select...</option>");
		                    sb.append("      <option value=\"feedback\">Feedback</option>");
		                    sb.append("      <option value=\"inquiry\">Inquiry</option>");
		                    sb.append("      <option value=\"complaint\">Complaint</option>");
		                    break;
		                case "feedback":
		                    sb.append("      <option value=\"null\">Select...</option>");
		                    sb.append("      <option selected value=\"feedback\">Feedback</option>");
		                    sb.append("      <option value=\"inquiry\">Inquiry</option>");
		                    sb.append("      <option value=\"complaint\">Complaint</option>");
		                    break;
		                case "inquiry":
		                    sb.append("      <option value=\"null\">Select...</option>");
		                    sb.append("      <option value=\"feedback\">Feedback</option>");
		                    sb.append("      <option selected value=\"inquiry\">Inquiry</option>");
		                    sb.append("      <option value=\"complaint\">Complaint</option>");
		                    break;
		                case "complaint":
		                    sb.append("      <option value=\"null\">Select...</option>");
		                    sb.append("      <option value=\"feedback\">Feedback</option>");
		                    sb.append("      <option value=\"inquiry\">Inquiry</option>");
		                    sb.append("      <option selected value=\"complaint\">Complaint</option>");
		                    break;
		                default:
		                    break;
		            }
		        }
		        sb.append("   </select>");
		        sb.append("  </div>");
				
				sb.append("            <div class=\"form-group\">\n" + 
						"                <label for=\"message\">*Message:</label><br>\n"); 
					if(message != null) {
		            if(message.equals("")) {
		                sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\" ></textarea>");
		            } else {
		                sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\">" + message + "</textarea>");
		            }
		        } else {
		            sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\" ></textarea>");
		        }
						sb.append("            </div>\n" + 
						"            <div class = \"form-group\">\n" + 
						"                 <button type=\"submit\" id =\"submit\" class=\"btn btn-primary\">Submit</button>\n" + 
						"            </div>\n" + 
						"            <footer>Hit count for this page:  "+ hitCount + "<span class = \"float-right\">Total hit count for the entire WebApp: "+ totalHitCount + " </span></footer>\n" + 
						"        </form>\n" + 
						"\n" + 
						"    </div>\n" + 
						"</body>\n" + 
						"</html>");
				 response.getWriter().println(sb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
