package com.cts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="interview")
public class Interview {
	
	
	private int interviewId;
	private String companyName;
	private String date;
	private String failedquestions;
	private String answers;
	
	@Column(name="interviewid")
	@Id
	@GeneratedValue
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	
	@Column(name="companyname")
    @JsonProperty("companyname")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="failedquestions")
	public String getFailedquestions() {
		return failedquestions;
	}
	public void setFailedquestions(String failedquestions) {
		this.failedquestions = failedquestions;
	}
	@Column(name="answers")
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	

}
