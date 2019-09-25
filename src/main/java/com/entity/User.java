package com.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity

public class User {
	private int id;
	private String name;
	private boolean sex;
	private String address;
	private String username;
	private String password;
	private boolean enable;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	

	public User(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public User(int id, String name, boolean sex, String address, String username, String password, boolean enable,
			Set<UserRole> userRole) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.userRole = userRole;
	}

	public User(String username, String password, boolean enable, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.userRole = userRole;
	}

	public User() {
		
	}
	@Column(name = "id")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Id
	@Column(name = "username", unique = true, length = 32, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 32, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enable", nullable = false)
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
