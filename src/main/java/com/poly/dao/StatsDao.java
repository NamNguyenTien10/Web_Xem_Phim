package com.poly.dao;

import java.util.List;

import com.poly.entity.User;
import com.poly.entity.VideoLikedInfo;

public interface StatsDao {
	List<VideoLikedInfo> findVideoLiked();
	
}
