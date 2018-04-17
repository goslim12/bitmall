package com.cafe24.bitmall.vo;

public class ProductVo {
	private Long no;
	private String title;
	private Long price;
	private Long categoryNo;
	private String path;
	private boolean delete;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", title=" + title + ", price=" + price + ", categoryNo=" + categoryNo
				+ ", path=" + path + ", delete=" + delete + "]";
	}
	
}
