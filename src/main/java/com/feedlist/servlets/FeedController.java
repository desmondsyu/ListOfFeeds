package com.feedlist.servlets;

import java.io.IOException;
import java.util.List;

import com.feedlist.models.Feed;
import com.feedlist.services.FeedService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedController")
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FeedService feedService;

	public FeedController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		feedService = new FeedService();
		getServletContext().log(" servlet initialized.");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getMethod();
		String requestUrl = request.getRequestURL().toString();
		getServletContext().log("Incoming request: " + requestType + " " + requestUrl);
		super.service(request, response);
	}

	@Override
	public void destroy() {
		getServletContext().log("The servlet is being terminated.");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Feed> feedList = feedService.loadFeeds(getServletContext());
		request.setAttribute("feedList", feedList);
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("jstl")) {
			request.getRequestDispatcher("/feedListJSTL.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("custom")) {
			request.getRequestDispatcher("/feedListCustomTag.jsp").forward(request, response);
		} else {

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
