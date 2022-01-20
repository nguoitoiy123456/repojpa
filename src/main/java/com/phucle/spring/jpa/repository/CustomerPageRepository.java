package com.phucle.spring.jpa.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Province;


public interface CustomerPageRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, org.springframework.data.domain.Pageable pageable);
}

