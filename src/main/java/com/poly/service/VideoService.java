package com.poly.service;

import java.util.List;

import com.poly.entity.Video;

public interface VideoService {
	Video findbyId(Integer id);
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAllPage(int pageNumber, int pageSize);
	Video add(Video enitiy);
	Video update(Video enitiy);
	Video delete(Video enitiy);
}
