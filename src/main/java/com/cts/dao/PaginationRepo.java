package com.cts.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cts.model.Interview;

public interface PaginationRepo extends PagingAndSortingRepository<Interview, Integer>{

}
