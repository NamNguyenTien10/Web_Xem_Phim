package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = { "/index", "/favorite", "/history" })
public class HomeController extends HttpServlet {
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	private int VIDEO_MAX_PAGE_SIZE = 10;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/favorite":
			doGetFavorite(session, req, resp);
			break;
		case "/history":
			doGetHistory(session, req, resp);
			break;
		}
	}

	private void doGetFavorite(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> his = historyService.findByUserAndIsLiked(user.getUsername());
		List<Video> video = new ArrayList<>();
		for (int i = 0; i < his.size(); i++) {
			video.add(his.get(i).getVideo());
		}
		
		req.setAttribute("video", video);
		req.getRequestDispatcher("/view/user/html/favorite.jsp").forward(req, resp);
	}
	
	private void doGetHistory(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> his = historyService.findByUser(user.getUsername());
		List<Video> video = new ArrayList<>();
		for (int i = 0; i < his.size(); i++) {
			video.add(his.get(i).getVideo());
		}
		
		req.setAttribute("video", video);
		req.getRequestDispatcher("/view/user/html/history.jsp").forward(req, resp);
	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Video> countVideo = videoService.findAll();
		int maxPage = (int) Math.ceil(countVideo.size() / (double) VIDEO_MAX_PAGE_SIZE);
		req.setAttribute("maxPage", maxPage);

		List<Video> video;
		String pageNumber = req.getParameter("page");
		if (pageNumber == null || maxPage < Integer.valueOf(pageNumber)) {
			video = videoService.findAllPage(1, VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", 1);
		} else {
			video = videoService.findAllPage(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", Integer.valueOf(pageNumber));
		}
		req.setAttribute("video", video);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
