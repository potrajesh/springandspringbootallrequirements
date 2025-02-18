package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Interview;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Integer>{

}
