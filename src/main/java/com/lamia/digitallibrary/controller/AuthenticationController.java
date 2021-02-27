package com.lamia.digitallibrary.controller;

import com.lamia.digitallibrary.dao.IUserDao;
import com.lamia.digitallibrary.model.User;
import com.lamia.digitallibrary.model.UserSession;
import com.lamia.digitallibrary.view.DashboardView;
import com.lamia.digitallibrary.view.HomeView;
public class AuthenticationController {

	private DashboardView dashboardView;
	private HomeView homeView;
	private IUserDao userDao;
	
	public AuthenticationController() {
		super();
	}

	public AuthenticationController(DashboardView dashboardView, HomeView homeView, IUserDao userDao) {
		super();
		this.dashboardView = dashboardView;
		this.homeView = homeView;
		this.userDao = userDao;
	}

	public void login(String username, String password, String userType){
		
		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password) && userType.equalsIgnoreCase("student")) {
			UserSession.setLoggedInUser(user);
			dashboardView.showDashboardStudent();
			return;
		}
		else if (user != null && user.getPassword().equals(password) && userType.equalsIgnoreCase("librarian")){
			UserSession.setLoggedInUser(user);
			dashboardView.showDashboardLibrarian();
			return;
		}
		
		homeView.showLoginOptions(true);
	}

	public void logout(){
		UserSession.setLoggedInUser(null);
		homeView.showInitialOptions(true);
	}

	public DashboardView getDashboardView() {
		return dashboardView;
	}

	public void setDashboardView(DashboardView dashboardView) {
		this.dashboardView = dashboardView;
	}

	public HomeView getHomeView() {
		return homeView;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
}



















