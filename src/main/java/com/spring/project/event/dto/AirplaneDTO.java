package com.spring.project.event.dto;

import java.sql.Date;

public class AirplaneDTO {
	private int air_no;
    private String air_airline;
    private Date air_Date;
    private String air_departTime;
    private String air_arrivalTime;
	private String air_departPlace;
	private String air_arrivalPlace;
	private int air_price;
	
	
	public Date getAir_Date() {
		return air_Date;
	}
	public void setAir_Date(Date air_Date) {
		this.air_Date = air_Date;
	}
	public int getAir_no() {
		return air_no;
	}
	public void setAir_no(int air_no) {
		this.air_no = air_no;
	}
	public String getAir_airline() {
		return air_airline;
	}
	public void setAir_airline(String air_airline) {
		this.air_airline = air_airline;
	}
	public String getAir_departTime() {
		return air_departTime;
	}
	public void setAir_departTime(String air_departTime) {
		this.air_departTime = air_departTime;
	}
	public String getAir_arrivalTime() {
		return air_arrivalTime;
	}
	public void setAir_arrivalTime(String air_arrivalTime) {
		this.air_arrivalTime = air_arrivalTime;
	}
	public String getAir_departPlace() {
		return air_departPlace;
	}
	public void setAir_departPlace(String air_departPlace) {
		this.air_departPlace = air_departPlace;
	}
	public String getAir_arrivalPlace() {
		return air_arrivalPlace;
	}
	public void setAir_arrivalPlace(String air_arrivalPlace) {
		this.air_arrivalPlace = air_arrivalPlace;
	}
	public int getAir_price() {
		return air_price;
	}
	public void setAir_price(int air_price) {
		this.air_price = air_price;
	}
	
	
}
