package com.poly.service.impl;

import java.util.List;

import com.poly.dao.VideoDao;
import com.poly.dao.VideoDaoImpl;
import com.poly.entity.Video;
import com.poly.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private VideoDao dao;
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();
	}
	
	@Override
	public Video findbyId(Integer id) {
		return dao.findbyId(id);
	}

	@Override
	public Video findByHref(String href) {
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAllPage(int pageNumber, int pageSize) {
		return dao.findAllPage(pageNumber, pageSize);
	}

	@Override
	public Video add(Video enitiy) {
		return dao.add(enitiy);
	}

	@Override
	public Video update(Video enitiy) {
		return dao.update(enitiy);
	}

	@Override
	public Video delete(Video entity) {
		return dao.delete(entity);
	}


}
