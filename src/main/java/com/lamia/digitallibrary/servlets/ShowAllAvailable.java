package com.lamia.digitallibrary.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lamia.digitallibrary.dao.BookDaoJpaImpl;
import com.lamia.digitallibrary.dao.IBookDao;
import com.lamia.digitallibrary.model.Book;

/**
 * Servlet implementation class ShowAllAvailable
 */
@WebServlet("/showallavailable")
public class ShowAllAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllAvailable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookDao bookDao = new BookDaoJpaImpl();
		List<Book> foundBooks = bookDao.findAllAvailable(); //find all available books
		request.setAttribute("foundBook", foundBooks);
		request.getRequestDispatcher("/WEB-INF/views/UpdateBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
