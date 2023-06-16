package com.poly.entity;

public class VideoLikedInfo {
	private Integer videoId;
	private String title;
	private String href;
	private Integer totalLike;
	
	public VideoLikedInfo() {
		super();
	}

	public VideoLikedInfo(Integer videoId, String title, String href, Integer totalLike) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.href = href;
		this.totalLike = totalLike;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}

	@Override
	public String toString() {
		return "VideoLikedInfo [videoId=" + videoId + ", title=" + title + ", href=" + href + ", totalLike=" + totalLike
				+ "]";
	}
	
	
}
