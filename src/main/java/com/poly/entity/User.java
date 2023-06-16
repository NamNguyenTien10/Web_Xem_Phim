package com.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.poly.constant.NamedStored;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = NamedStored.FIND_USERS_LIKED_VIEO_BY_HREF, 
				procedureName = "sp_selectUsersLikedVideobyVideoHref", 
				resultClasses = {User.class }, 
				parameters = @StoredProcedureParameter(name = "videoHref", type = String.class)) 
		})
@Entity
@Table(name = "`user`")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "isAdmin")
	private Boolean isAdmin;

	@Column(name = "isActive")
	private Boolean isActive;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String email, Boolean isAdmin, Boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", isAdmin=" + isAdmin + ", isActive=" + isActive + "]";
	}

}
