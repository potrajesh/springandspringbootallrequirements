package com.cts.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dao.InterviewRepo;
import com.cts.model.Interview;
import com.cts.service.InterviewService;

@RestController
public class InterviewController {

    private static final Logger logger = LoggerFactory.getLogger(InterviewController.class);

    @Autowired
    private InterviewService interviewService;
    
    @Autowired
    private InterviewRepo interviewRepo;
    
    @PostMapping("saveinterview")
    public String saveInterview(@RequestBody Interview interview){
    	interviewService.save(interview);
        return "record successfully saved into database";
    }

    @PutMapping("updateInterview/{id}")
    public void updateInterview(@PathVariable Integer id,@RequestBody Interview interview) {
    	
    	 Optional<Interview> i = interviewRepo.findById(id);
    	if(i.isPresent()) {
    		Interview entityInterview = i.get();
    		entityInterview.setAnswers(interview.getAnswers());
    		entityInterview.setCompanyName(interview.getCompanyName());
    		entityInterview.setDate(interview.getDate());
    		entityInterview.setFailedquestions(interview.getFailedquestions());
    		entityInterview.setInterviewId(interview.getInterviewId());
    		interviewService.updateInterview(entityInterview);
    	}
    	else {
    		System.out.println("no update");
    	}
    }
    @DeleteMapping("deleteByInterviewId/{id}")
    public String deleteInterview(@PathVariable Integer id) {
    	Optional<Interview> byId = interviewRepo.findById(id);
    	if(byId.isPresent()) {
    		Interview interview = byId.get();
    		interviewRepo.delete(interview);
    	}
        return "record successfully deleted from database";
    }
    
    //int page-->means enni pages ki
    //int pagesize enni records shown ani.
    @GetMapping("nextpages")
	public Page<Interview> list(@RequestParam(defaultValue = "0") 
	int page,@RequestParam(defaultValue = "3") int pageSize) {
    	 if (page < 0) page = 0;
         if (pageSize < 1) pageSize = 3;  // Ensure at least 1 record per page
    	PageRequest pages = PageRequest.of(page, pageSize);
		Page<Interview> listAllByPage = interviewService.listAllByPage(pages);
		return listAllByPage;

	}
    
}
