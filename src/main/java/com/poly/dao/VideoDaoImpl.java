package com.poly.dao;

import java.util.List;

import com.poly.entity.User;
import com.poly.entity.Video;

public class VideoDaoImpl extends AbstractDAO<Video> implements VideoDao {

	@Override
	public Video findbyId(Integer id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql = "select o from Video o where o.href = ?0";
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAllPage(int pageNumber, int pageSize) {
		return super.findAllPage(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public Video add(Video enitiy) {
		// TODO Auto-generated method stub
		return super.add(enitiy);
	}

	@Override
	public Video update(Video enitiy) {
		// TODO Auto-generated method stub
		return super.update(enitiy);
	}

	@Override
	public Video delete(Video enitiy) {
		// TODO Auto-generated method stub
		return super.delete(enitiy);
	}

}
