package com.dto;

import java.time.LocalDate;

public class Medicine {
	
	private String id;
	private String name;
	private String company;
	private double price;
	private LocalDate mfgdate;
	private LocalDate  expdate;
	public Medicine(String id, String name, String company, double price, LocalDate mfgdate, LocalDate expdate) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.price = price;
		this.mfgdate = mfgdate;
		this.expdate = expdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(LocalDate mfgdate) {
		this.mfgdate = mfgdate;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", company=" + company + ", price=" + price + ", mfgdate="
				+ mfgdate + ", expdate=" + expdate + "]";
	}
	
	


}
