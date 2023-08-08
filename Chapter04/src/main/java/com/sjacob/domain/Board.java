package com.sjacob.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String wrtier;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWrtier() {
		return wrtier;
	}
	public void setWrtier(String wrtier) {
		this.wrtier = wrtier;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", wrtier=" + wrtier + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
   
}
