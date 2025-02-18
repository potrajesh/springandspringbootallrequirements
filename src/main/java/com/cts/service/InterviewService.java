package com.cts.service;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cts.dao.InterviewRepo;
import com.cts.model.Interview;

@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepo interviewRepo;
	
	public void save(Interview interview) {
		
		interviewRepo.save(interview);
	}

	public void updateInterview(Interview entityInterview) {
		interviewRepo.save(entityInterview);
		
	}
	public  org.springframework.data.domain.Page<Interview> listAllByPage(Pageable pagable){
		  
		  return interviewRepo.findAll(pagable);
		  	
	}	

}
