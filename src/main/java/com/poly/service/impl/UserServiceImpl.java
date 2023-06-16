package com.poly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.dao.UserDao;
import com.poly.dao.UserDaoImpl;
import com.poly.entity.User;
import com.poly.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User findbyId(Integer id) {
		return dao.findbyId(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAllPage(int pageNumber, int pageSize) {
		return dao.findAllPage(pageNumber, pageSize);
	}

	@Override
	public User add(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIsAdmin(Boolean.FALSE);
		user.setIsActive(Boolean.TRUE);
		return dao.add(user);
	}

	@Override
	public User update(User enitiy) {
		return dao.update(enitiy);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

	@Override
	public List<User> findUsersLikedByHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		return dao.findUsersLikedByVideoHref(params);
	}

	@Override
	public String updatePassword(String password) {
		return dao.updatePassword(password);
	}

}
