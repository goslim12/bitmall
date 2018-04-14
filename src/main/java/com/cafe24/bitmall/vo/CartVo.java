package com.cafe24.bitmall.vo;

public class CartVo {
	private Long productNo;
	private Long memberNo;
	private Long count;
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartVo [productNo=" + productNo + ", memberNo=" + memberNo + ", count=" + count + "]";
	}

}
