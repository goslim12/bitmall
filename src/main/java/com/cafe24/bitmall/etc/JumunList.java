package com.cafe24.bitmall.etc;

public class JumunList implements Comparable<JumunList>{
	private String date;
	private String orderNo;
	private String title;
	private String price;
	private String state;
	private Long orderKeyNo;
	
	public int compareTo(JumunList jumun) {
		if (Long.valueOf(this.orderNo) < Long.valueOf(jumun.orderNo)) {
			return 1;
		} else if ((Long.valueOf(this.orderNo)== Long.valueOf(jumun.orderNo))) {
			return 0;
		} else {
			return -1;
		}
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getOrderKeyNo() {
		return orderKeyNo;
	}
	public void setOrderKeyNo(Long orderKeyNo) {
		this.orderKeyNo = orderKeyNo;
	}
	@Override
	public String toString() {
		return "JumunList [date=" + date + ", orderNo=" + orderNo + ", title=" + title + ", price=" + price + ", state="
				+ state + ", orderKeyNo=" + orderKeyNo + "]";
	}
	
}
