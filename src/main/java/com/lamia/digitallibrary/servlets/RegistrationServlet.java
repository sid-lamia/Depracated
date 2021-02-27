package com.lamia.digitallibrary.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lamia.digitallibrary.dao.IUserDao;
import com.lamia.digitallibrary.dao.UserDaoJpaImpl;
import com.lamia.digitallibrary.model.Student;
import com.lamia.digitallibrary.model.User;
import com.lamia.digitallibrary.util.MyLogger;
import com.lamia.digitallibrary.view.HomeView;
import com.lamia.digitallibrary.view.RegistrationView;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserDao userDao;
	private RegistrationView registrationView;
	private HomeView homeView;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String grade = request.getParameter("grade");
		
		IUserDao userDao = new UserDaoJpaImpl();
		//checking for empty fields
		if(firstName.length() !=0 && lastName.length() != 0 && email.length() != 0 && password.length() != 0 && grade.length() != 0){
			List<String> usernames = userDao.findAllUsernames();
			//checking for duplicate username/email
			if(usernames.contains(email)){
				request.setAttribute("emptyfieldmsg", "There is already an account associated with this username!");
				request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);
			}
			else{
				User registeredUser = new Student(email, password, firstName, lastName, grade);
				userDao.create(registeredUser);
				MyLogger.trace("Registering new user");
				request.setAttribute("registeredmsg", "Congratulations! You are now registered, please login with your username and password to continue");
				request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("emptyfieldmsg", "Please complete all the fields to register");
			request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);
		}

	} 

}
