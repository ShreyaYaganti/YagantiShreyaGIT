package com.elitefs.servlets.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet(description = "Single and Multiple Parameters", urlPatterns = { "/UserProfile", "/userprofile" })
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>User Profile</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<FORM METHOD=POST>");
		out.println("<H2><BR>First Name: <INPUT TYPE=TEXT NAME=FirstName>");
		out.println("<BR>Last Name: <INPUT TYPE=TEXT NAME=LastName>");
		out.println("<BR>");
		out.println("<BR>Select your favorite music:");
		out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Rock>Rock");
		out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Jazz>Jazz");
		out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Classical>Classical");
		out.println("<BR><INPUT TYPE=CHECKBOX " + "NAME=favoriteMusic VALUE=Country>Country");
		out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		showRequestHeaders(request);

	String[] values = request.getParameterValues("favoriteMusic");
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<H2><BR>Hello, " + firstName + " " + lastName);
		if (values != null) {
			int length = values.length;
			out.println("<p>Your favorite Music is: ");
			for (int i = 0; i < length; i++) {
				out.println("<BR>" + values[i]);
			}
		}
	}

	private void showRequestHeaders(HttpServletRequest request) {
		Enumeration enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String header = (String) enumeration.nextElement();
			System.out.println(header + ": " + request.getHeader(header));
		}

	}
}
