package com.poly.dao;

import java.util.List;
import java.util.Map;


import com.poly.constant.NamedStored;
import com.poly.entity.User;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao{

	@Override
	public User findbyId(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select o from User o where o.username = ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "select o from User o where o.username = ?0 and o.password = ?1";
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAllPage(int pageNumber, int pageSize) {
		return super.findAllPage(User.class, true, pageNumber, pageSize);
	}
	
	@Override
	public User add(User enitiy) {
		return super.add(enitiy);
	}

	@Override
	public User update(User enitiy) {
		return super.update(enitiy);
	}

	@Override
	public User delete(User enitiy) {
		return super.delete(enitiy);
	}

	@Override
	public List<User> findUsersLikedByVideoHref(Map<String, Object> params) {
		return super.callStored(NamedStored.FIND_USERS_LIKED_VIEO_BY_HREF, params);
	}

	@Override
	public String updatePassword(String password) {
		return super.update(password);
	}


	

}
