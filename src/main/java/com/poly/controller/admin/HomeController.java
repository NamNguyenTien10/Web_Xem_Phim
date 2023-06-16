package com.poly.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.entity.VideoLikedInfo;
import com.poly.service.StatsService;
import com.poly.service.UserService;
import com.poly.service.VideoService;
import com.poly.service.impl.StatsServiceImpl;
import com.poly.service.impl.UserServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = { "/admin", "/admin/favorite", "/admin/user/view", "/admin/video/view", "/admin/video/delete",
		"/admin/video/add", "/admin/video/edit", "/admin/video/view-add",
		"/admin/video/view-edit" }, name = "HomeControllerOfAdmin")
public class HomeController extends HttpServlet {
	private StatsService stasService = new StatsServiceImpl();
	private UserService userService = new UserServiceImpl();
	private VideoService videoService = new VideoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		switch (path) {
		case "/admin":
			doGetHome(req, resp);
			break;
		case "/admin/favorite":
			req.setAttribute("view", "/view/admin/admin.jsp");
			doGetFavorites(req, resp);
			break;
		case "/admin/user/view":
			req.setAttribute("view", "/view/admin/list_user.jsp");
			doGetUser(req, resp);
			break;
		case "/admin/video/view":
			req.setAttribute("view", "/view/admin/list_video.jsp");
			doGetVideo(req, resp);
			break;
		case "/admin/video/delete":
			deleteVideo(req, resp);
			break;
		case "/admin/video/view-add":
			req.setAttribute("view", "/view/admin/new_video.jsp");
			viewAddVideo(req, resp);
			break;
		case "/admin/video/view-edit":
			req.setAttribute("view", "/view/admin/edit_video.jsp");
			viewEditVideo(req, resp);
			break;
		}
	}

	private void viewEditVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Video video = videoService.findbyId(Integer.valueOf(id));
		req.setAttribute("vid", video);
		req.getRequestDispatcher("/view/admin/edit_video.jsp").forward(req, resp);
	}

	private void viewAddVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/admin/new_video.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/admin/video/add":
			newVideo(req, resp);
			break;
		case "/admin/video/edit":
			editVideo(req, resp);
			break;
		}
	}

	private void editVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String href = req.getParameter("href");
		String description = req.getParameter("description");
		String poster = req.getParameter("poster"); 
		
		Video video = videoService.findbyId(Integer.valueOf(id));
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		video.setIsActive(true);
		video.setShares(0);
		video.setViews(0);
		videoService.update(video);
		resp.sendRedirect("/Web_Xem_Phim/admin/video/view");
	}

	private void newVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = req.getParameter("title");
		String href = req.getParameter("href");
		String description = req.getParameter("description");
		String poster = req.getParameter("poster");

		Video vid = new Video(null, title, href, poster, 0, 0, description, true);
		videoService.add(vid);
		resp.sendRedirect("/Web_Xem_Phim/admin/video/view");

	}

	private void deleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Video vid = videoService.findbyId(Integer.valueOf(id));
		videoService.delete(vid);
		resp.sendRedirect("/Web_Xem_Phim/admin/video/view");
	}

	private void doGetVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> listVideo = videoService.findAll();
		req.setAttribute("video", listVideo);
		req.getRequestDispatcher("/view/admin/list_video.jsp").forward(req, resp);
	}

	private void doGetUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = userService.findAll();
		req.setAttribute("user", users);
		req.getRequestDispatcher("/view/admin/list_user.jsp").forward(req, resp);
	}

	private void doGetFavorites(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		String videoHref = req.getParameter("href");
		List<User> users = userService.findUsersLikedByHref(videoHref);
		if (users.isEmpty()) {
			resp.setStatus(400);
		} else {
			// Ép kiểu Objet => json
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			resp.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}
	}

	private void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);

		if (user != null && user.getIsAdmin() == true) {
			List<VideoLikedInfo> videoLiked = stasService.findVideoLiked();
			req.setAttribute("videoLiked", videoLiked);
			req.getRequestDispatcher("/view/admin/admin.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("index");
		}
	}
}
