package com.poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.VideoService;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet({"/admin/video"})
public class VideoController extends HttpServlet{
	VideoService videoService = new VideoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (user != null && user.getIsAdmin() == true) {
			String uri = req.getRequestURI();
			
			if (uri.contains("/admin/video/view")) {
				this.viewListVideo(req, resp);
			}
		} else {
			resp.sendRedirect("index");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/admin/list_video.jsp").forward(req, resp);
	}
	private void viewListVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> listVideo = videoService.findAll();
		req.setAttribute("video", listVideo);
		req.getRequestDispatcher("/view/admin/list_video.jsp").forward(req, resp);
	}
}
