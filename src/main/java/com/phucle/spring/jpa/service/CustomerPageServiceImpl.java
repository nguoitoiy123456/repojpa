package com.phucle.spring.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Province;
import com.phucle.spring.jpa.repository.CustomerPageRepository;

import com.phucle.spring.jpa.service.define.PageService;


@Service
public class CustomerPageServiceImpl implements PageService<Customer> {

	@Autowired
    private CustomerPageRepository customerPageRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerPageRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerPageRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
    	customerPageRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
    	customerPageRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerPageRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerPageRepository.findAllByFirstNameContaining(firstname, pageable) ;
    }

}
