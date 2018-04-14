package com.cafe24.bitmall.vo;

public class OrderVo {
	private Long no;
	private Long memberNo;
	private Long recipientNo;
	private Long paymentNo;
	private Long ordererNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getRecipientNo() {
		return recipientNo;
	}
	public void setRecipientNo(Long recipientNo) {
		this.recipientNo = recipientNo;
	}
	public Long getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(Long paymentNo) {
		this.paymentNo = paymentNo;
	}
	public Long getOrdererNo() {
		return ordererNo;
	}
	public void setOrdererNo(Long ordererNo) {
		this.ordererNo = ordererNo;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", memberNo=" + memberNo + ", recipientNo=" + recipientNo + ", paymentNo="
				+ paymentNo + ", ordererNo=" + ordererNo + "]";
	}
	
}
