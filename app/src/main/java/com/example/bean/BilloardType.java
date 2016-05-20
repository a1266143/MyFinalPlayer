package com.example.bean;

/**
 * 歌单简介
 * @author 李晓军
 *
 */
public class BilloardType {
	private String updateDate;
	private String name;
	//概要信息
	private String comment;
	//标题图片链接
	private String pics640;
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPics640() {
		return pics640;
	}
	public void setPics640(String pics640) {
		this.pics640 = pics640;
	}
	
}
