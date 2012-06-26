package com.mti.webshare.model;

import javax.persistence.*;

@Entity
@Table(name = "Shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer evalId;
	
	private Integer evalNote;
	
	@Column(name="eval_comment", length=1024)
	private String evalComment;

	public Integer getEvalId() {
		return evalId;
	}

	public void setEvalId(Integer evalId) {
		this.evalId = evalId;
	}

	public Integer getEvalNote() {
		return evalNote;
	}

	public void setEvalNote(Integer evalNote) {
		this.evalNote = evalNote;
	}

	public String getEvalComment() {
		return evalComment;
	}

	public void setEvalComment(String evalComment) {
		this.evalComment = evalComment;
	}	
}
