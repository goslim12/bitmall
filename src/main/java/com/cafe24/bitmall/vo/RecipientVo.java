package com.cafe24.bitmall.vo;

public class RecipientVo {
	private Long no;
	private String name;
	private String telephone;
	private String phone;
	private String email;
	private String zip;
	private String address;
	private String requirement;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	@Override
	public String toString() {
		return "RecipientVo [no=" + no + ", name=" + name + ", telephone=" + telephone + ", phone=" + phone + ", email="
				+ email + ", zip=" + zip + ", address=" + address + ", requirement=" + requirement + "]";
	}
	
}
