package com.poly.service;

import java.util.List;

import com.poly.entity.User;

public interface UserService {
	User findbyId(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAllPage(int pageNumber, int pageSize);
	User add(String username, String password, String email);
	User update(User enitiy);
	User delete(String username);
	List<User> findUsersLikedByHref(String href);
	String updatePassword(String password);
}
