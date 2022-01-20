package com.phucle.spring.jpa.service.define;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Province;
@Service
public interface PageService <T>{
	  Page<T> findAll(Pageable pageable);

	    T findById(Long id);

	    void save(T t);

	    void remove(Long id);

	    Iterable<Customer> findAllByProvince(Province province);

	    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
