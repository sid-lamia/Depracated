package com.lamia.digitallibrary.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lamia.digitallibrary.dao.BookDaoJpaImpl;
import com.lamia.digitallibrary.dao.IBookDao;
import com.lamia.digitallibrary.model.Book;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/UpdateBookSearch.jsp").forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this method is invoked when the update button is clicked
		String updatedBookIsbn = request.getParameter("updatebook");
		IBookDao bookDao = new BookDaoJpaImpl();
		Book updatedBook = bookDao.findById(Integer.parseInt(updatedBookIsbn));
		
		if(updatedBook.getAvailability().equals("Not Available")){
			bookDao.update(updatedBook);		
			request.getRequestDispatcher("/WEB-INF/views/UpdateBookSearch.jsp").forward(request, response);	
		}
		else{
			request.setAttribute("cannotmsg", "This book is already available, cannot update!");
			request.getRequestDispatcher("/WEB-INF/views/UpdateBookSearch.jsp").forward(request, response);	
		}
	}

}
