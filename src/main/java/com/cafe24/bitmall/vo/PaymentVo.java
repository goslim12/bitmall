package com.cafe24.bitmall.vo;

public class PaymentVo {
	private Long no;
	private String orderNo;
	private Long price;
	private String way;
	private String approval;
	private String cardKind;
	private String instalment;
	private String orderer;
	private String bankKind;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getCardKind() {
		return cardKind;
	}
	public void setCardKind(String cardKind) {
		this.cardKind = cardKind;
	}
	public String getInstalment() {
		return instalment;
	}
	public void setInstalment(String instalment) {
		this.instalment = instalment;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getBankKind() {
		return bankKind;
	}
	public void setBankKind(String bankKind) {
		this.bankKind = bankKind;
	}
	@Override
	public String toString() {
		return "PaymentVo [no=" + no + ", orderNo=" + orderNo + ", price=" + price + ", way=" + way + ", approval="
				+ approval + ", cardKind=" + cardKind + ", instalment=" + instalment + ", orderer=" + orderer
				+ ", bankKind=" + bankKind + "]";
	}
	
}
