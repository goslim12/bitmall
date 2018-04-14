package com.cafe24.bitmall.vo;

public class OrderProductVo {
	private Long orderNo;
	private Long productNo;
	private Long count;
	private Long price;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderProductVo [orderNo=" + orderNo + ", productNo=" + productNo + ", count=" + count + ", price="
				+ price + "]";
	}
	
}
