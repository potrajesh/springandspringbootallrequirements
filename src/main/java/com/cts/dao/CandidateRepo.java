package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer>{

}
