package com.poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.poly.dao.HistoryDao;
import com.poly.dao.HistoryDaoImpl;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;

public class HistoryServiceImpl implements HistoryService {
	HistoryDao dao;
	VideoService videoService = new VideoServiceImpl();

	public HistoryServiceImpl() {
		dao = new HistoryDaoImpl();
	}

	@Override
	public List<History> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		return dao.findByUserAndIsLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History add(User user, Video video) {
		History his = findByUserIdAndVideoId(user.getId(), video.getId());
		if (his == null) {
			his = new History();
			his.setUser(user);
			his.setVideo(video);
			his.setIsLiked(Boolean.FALSE);
			his.setLikedDate(null);
			return dao.add(his);
		}
		return his;
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String href) {
		Video video = videoService.findByHref(href);
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());

		if (existHistory.getIsLiked() == false) {
			existHistory.setIsLiked(true);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		} else {
			existHistory.setIsLiked(false);
			existHistory.setLikedDate(null);
		}

		History his = dao.update(existHistory);
		return his != null ? true : false;
	}

}
