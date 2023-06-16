package com.poly.dao;

import java.util.List;
import java.util.Map;

import com.poly.entity.User;

public interface UserDao {
	User findbyId(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	List<User> findAllPage(int pageNumber, int pageSize);
	User add(User enitiy);
	User update(User enitiy);
	String updatePassword(String password);
	User delete(User enitiy);
	List<User> findUsersLikedByVideoHref(Map<String, Object> params);
}
