package com.cts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "interview")
public class Interview {
	private int interviewId;
	private String companyName;
	private String date;
	private String failedquestions;
	private String answers;

	public Interview() {
		super();
	}

	public Interview(int interviewId, String companyName, String date, String failedquestions, String answers,
			List<Candidate> candidate) {
		super();
		this.interviewId = interviewId;
		this.companyName = companyName;
		this.date = date;
		this.failedquestions = failedquestions;
		this.answers = answers;
		this.candidate = candidate;
	}

	private List<Candidate> candidate;

	@OneToMany(mappedBy = "interview", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure AUTO_INCREMENT behavior
	@Column(name = "interviewid", nullable = false, unique = true)
	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	@Column(name = "companyname")
	@JsonProperty("companyname")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "failedquestions")
	public String getFailedquestions() {
		return failedquestions;
	}

	public void setFailedquestions(String failedquestions) {
		this.failedquestions = failedquestions;
	}

	@Column(name = "answers")
	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

}
