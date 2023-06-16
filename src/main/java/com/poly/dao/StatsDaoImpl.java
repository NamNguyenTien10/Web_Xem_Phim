package com.poly.dao;

import java.util.ArrayList;
import java.util.List;

import com.poly.entity.User;
import com.poly.entity.VideoLikedInfo;

public class StatsDaoImpl extends AbstractDAO<Object[]> implements StatsDao {

	@Override
	public List<VideoLikedInfo> findVideoLiked() {
		String sql = "select v.id, v.title, v.href, sum(cast(h.isLiked as int)) as totalLike"
				+ " from video v left join history h on v.id = h.videoId"
				+ " where v.isActive = 1"
				+ " group by v.id, v.href, v.title"
				+ " order by sum(cast(h.isLiked as int)) desc";
		List<Object[]> object = super.findManyByNativeQuery( sql);
		List<VideoLikedInfo> list = new ArrayList<>();
//		for (Object[] obj : object) {
//			VideoLikedInfo vidLiked = new VideoLikedInfo();
//			vidLiked.setVideoId((Integer)obj[0]);
//			vidLiked.setTitle((String) obj[1]);
//			vidLiked.setHref((String) obj[2]);
//			vidLiked.setTotalLike(obj[3] == null ? 0 : (Integer) obj[3]);
//			result.add(vidLiked);
//		}
		object.forEach(obj ->{
			VideoLikedInfo vidLiked = new VideoLikedInfo();
			vidLiked.setVideoId((Integer)obj[0]);
			vidLiked.setTitle((String) obj[1]);
			vidLiked.setHref((String) obj[2]);
			vidLiked.setTotalLike(obj[3] == null ? 0 : (Integer) obj[3]);
			list.add(vidLiked);
		});
		return list;
	}


}
