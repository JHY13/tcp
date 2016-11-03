package com.jspprj.web.entities;

import java.util.Date;

public class Notice {
	private String code;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;
	private String releaseyear;
	/*테이블에 따라 변수명과 컬럼영 동일하게 가져가기.*/
	
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	private String src;
	private String poster;

	

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regDate;
	}

	public void setRegdate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}

}
