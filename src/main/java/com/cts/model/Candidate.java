package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "candidate")
@Entity
public class Candidate {

	private int candidateId;
	private String candidateName;
	private Interview interview;

	public Candidate() {
		super();
	}

	public Candidate(int candidateId, String candidateName, Interview interview) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.interview = interview;
	}

	@ManyToOne
	@JoinColumn(name = "interviewId", nullable = false)
	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	@Column(name = "candidateid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	@Column(name = "candidatename")
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

}
