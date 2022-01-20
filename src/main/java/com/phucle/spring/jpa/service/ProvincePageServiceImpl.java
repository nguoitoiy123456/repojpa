package com.phucle.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Province;
import com.phucle.spring.jpa.repository.ProvincePageRepository;
import com.phucle.spring.jpa.service.define.PageService;
@Service
public class ProvincePageServiceImpl implements PageService<Province> {

	@Autowired
    private ProvincePageRepository provincePageRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provincePageRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return provincePageRepository.findById(Integer.parseInt(id.toString())).get();
    }

    @Override
    public void save(Province province) {
    	provincePageRepository.save(province);
    }

    @Override
    public void remove(Long id) {
    	provincePageRepository.findById(Integer.parseInt(id.toString()));
    }

	@Override
	public Iterable<Customer> findAllByProvince(Province province) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


}
