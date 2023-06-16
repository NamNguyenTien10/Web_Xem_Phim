package com.poly.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.poly.util.JpaUtil;

public class AbstractDAO<T> {
	public static final EntityManager entityManager = JpaUtil.getEntityManager();
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}
	
	public T findById(Class<T> clazz, Integer id) {
		return entityManager.find(clazz, id);
	}
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName(); // Lấy name entity
		
		// SELECT o FROM entity o WHERE isActive = 1
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o"); // Ghép chuỗi câu lệnh sql
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	
	public List<T> findAllPage(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		System.out.println("List: " +query.getResultList());
		return query.getResultList();
	}
	
	public T findOne(Class<T> clazz, String sql, Object... params /* tham số với độ dài biến đổi */) {
		// select o from user o where o.username = ?0 and o.password = ?1
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		} 
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	
	

	public List<T> findMany(Class<T> clazz, String sql, Object... params /* tham số với độ dài biến đổi */) {
		// select o from user o where o.username = ?0 and o.password = ?1
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		} 
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params /* tham số với độ dài biến đổi */) {
		// select o from user o where o.username = ?0 and o.password = ?1
		Query query = entityManager.createNativeQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		} 
		return query.getResultList();
	}
	
	public T add(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Add success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Add fail");
		}
		return null;
	}
	
	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Update success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Update fail");
		}
		return null;
	}
	
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Delete success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Delete fail");
		}
		return null;
	}
	
	public String update(String password) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(password);
			entityManager.getTransaction().commit();
			System.out.println("Update success");
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Update fail");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> callStored(String nameStored, Map<String, Object> params){
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(nameStored);
		params.forEach( (key, value) -> query.setParameter(key, value));
		return (List<T>)query.getResultList();
	}
}
