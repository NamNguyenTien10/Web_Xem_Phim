package com.poly.service;

import java.util.List;

import com.poly.entity.VideoLikedInfo;

public interface StatsService {
	List<VideoLikedInfo> findVideoLiked();
}
