package com.phucle.spring.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Hobby;
import com.phucle.spring.jpa.entity.Province;
import com.phucle.spring.jpa.service.ProvinceServiceImpl;
import com.phucle.spring.jpa.service.define.BaseService;
import com.phucle.spring.jpa.service.define.PageService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	private BaseService<Province> provinceService;
	@Autowired
	private PageService<Province> pageService;
	
	@GetMapping("/page")
	public String listprovinces(Pageable pageable,  Model theModel) {
		Page<Province> provinces;
		
			provinces = pageService.findAll(pageable);
		
		theModel.addAttribute("provinces", provinces);

		return "list-provinces-page";
	}
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		// LOG.debug("inside show customer-form handler method");
		Province theProvince = new Province();
		theModel.addAttribute("province", theProvince);

		return "province-form";
	}

	
	@PostMapping("/saveProvince")
	public String saveprovince(@ModelAttribute("province") Province theProvince) {
		provinceService.save(theProvince);
		return "redirect:/province/page";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("provinceId") int theId, Model theModel) {
		Province theProvince = provinceService.getByID(theId);
		theModel.addAttribute("province", theProvince);
		return "province-form";
	}

	@GetMapping("/delete")
	public String deleteprovince(@RequestParam("provinceId") int theId) {
		provinceService.deleteById(theId);
		return "redirect:/province/page";
	}
	

}
