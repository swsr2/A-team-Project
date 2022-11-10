package com.spring.project.food.dto;

import java.sql.Date;

public class FoodDTO {
	private int fd_no;	
	private String fd_name;
	private String fd_address;
	private Date fd_open;	
	private Date fd_close;	
	private int fd_score;	// 평점
	private String fd_category; // 맛집, 카페 
	
	public int getFd_no() {
		return fd_no;
	}
	public void setFd_no(int fd_no) {
		this.fd_no = fd_no;
	}
	public String getFd_name() {
		return fd_name;
	}
	public void setFd_name(String fd_name) {
		this.fd_name = fd_name;
	}
	public String getFd_address() {
		return fd_address;
	}
	public void setFd_address(String fd_address) {
		this.fd_address = fd_address;
	}
	public Date getFd_open() {
		return fd_open;
	}
	public void setFd_open(Date fd_open) {
		this.fd_open = fd_open;
	}
	public Date getFd_close() {
		return fd_close;
	}
	public void setFd_close(Date fd_close) {
		this.fd_close = fd_close;
	}
	public int getFd_score() {
		return fd_score;
	}
	public void setFd_score(int fd_score) {
		this.fd_score = fd_score;
	}
	public String getFd_category() {
		return fd_category;
	}
	public void setFd_category(String fd_category) {
		this.fd_category = fd_category;
	}
	
}
