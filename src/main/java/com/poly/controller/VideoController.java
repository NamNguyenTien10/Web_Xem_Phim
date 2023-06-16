package com.poly.controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");
		HttpSession session = req.getSession();

		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, req, resp);
			break;
		case "like":
			doGetLike(session, href, req, resp);
			break;
		}
	}

	private void doGetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		boolean result = historyService.updateLikeOrUnlike(currentUser, href);
		if (result == true) {
			resp.setStatus(204); // thành công nhưng không trả về db
		} else {
			resp.setStatus(400);
		}
	}

	private void doGetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = videoService.findByHref(href);
		req.setAttribute("video", video);

		User currentUser =  (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		if (currentUser != null) {
			History his = historyService.add(currentUser, video);
			req.setAttribute("LikedBtn", his.getIsLiked());
		} 

		req.getRequestDispatcher("/view/user/html/detail-video.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
