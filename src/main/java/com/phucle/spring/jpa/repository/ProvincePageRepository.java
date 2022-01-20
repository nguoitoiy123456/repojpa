package com.phucle.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.phucle.spring.jpa.entity.Province;
@Repository
public interface ProvincePageRepository extends PagingAndSortingRepository<Province, Integer> {

}
