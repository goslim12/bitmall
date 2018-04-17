package com.cafe24.bitmall.etc;

public class AdminJumunList implements Comparable<AdminJumunList>{
	private String orderNo;
	private String date;
	private String title;
	private Long count;
	private String price;
	private String orderName;
	private String way;
	private String state;
	private Long orderKeyNo;
	
	public int compareTo(AdminJumunList jumun) {
		if (Long.valueOf(this.orderNo) < Long.valueOf(jumun.orderNo)) {
			return 1;
		} else if ((Long.valueOf(this.orderNo)== Long.valueOf(jumun.orderNo))) {
			return 0;
		} else {
			return -1;
		}
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
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
		return "AdminJumunList [orderNo=" + orderNo + ", date=" + date + ", title=" + title + ", count=" + count
				+ ", price=" + price + ", orderName=" + orderName + ", way=" + way + ", state=" + state
				+ ", orderKeyNo=" + orderKeyNo + "]";
	}
	
	
}
