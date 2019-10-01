package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Entity(name = "course")
public class Course implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private Date startedDate;
	private Date endDate;
	@ManyToMany
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "username"))
	private Set<User> userList;
	private String detail;
	private int hocphi;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	
	public Set<User> getUserList() {
		return userList;
	}

	public String getDetail() {
		return detail;
	}

	public int getHocphi() {
		return hocphi;
	}

}
