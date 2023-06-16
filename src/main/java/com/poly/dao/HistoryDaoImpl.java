package com.poly.dao;

import java.util.List;

import com.poly.entity.History;
import com.poly.entity.Video;

public class HistoryDaoImpl extends AbstractDAO<History> implements HistoryDao {

	@Override
	public List<History> findByUser(String username) {
		String sql = "select o from History o where o.user.username = ?0 and o.video.isActive = 1"
				+" order by o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		String sql = "select o from History o where o.user.username = ?0 and o.isLiked = 1 and o.video.isActive = 1"
				+" order by o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String sql = "select o from History o where o.user.id = ?0 and o.video.id = ?1"
				+" and o.video.isActive = 1";
		return super.findOne(History.class, sql, userId, videoId);
	}
	


}
