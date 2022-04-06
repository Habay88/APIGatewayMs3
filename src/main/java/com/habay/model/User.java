package com.habay.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
 @Column(name = "username", unique= true, nullable=false, length=100)
	private String username;
	
 @Column(name = "password", nullable = false)
 private String password;
	@Column(name = "name", unique= true, nullable=false, length=100)
	private String name;
	@Column(name = "create_time",nullable = false)
	private LocalDateTime createTime;
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable = false)
	private Role role;
	
	@Transient
	private String token;
	public User() {
	
	}
	public User(Long id, String username, String password, String name, LocalDateTime createTime, Role role) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.createTime = createTime;
		this.role = role;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", createTime=" + createTime + ", role=" + role + "]";
	}
	
	
}
