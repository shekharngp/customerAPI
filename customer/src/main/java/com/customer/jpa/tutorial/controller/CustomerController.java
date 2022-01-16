package com.customer.jpa.tutorial.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.jpa.tutorial.entity.Customer;
import com.customer.jpa.tutorial.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
@RequestMapping("/customer")
public class CustomerController {

	Customer customer = new Customer();
	@Autowired
	private CustomerService customerService;

	ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/ping")
	public String ping() {
		return "Hello from Customer";
	}

	@PostMapping(value = "/upload")
	public Customer upload(@RequestParam(required = true, value = "jsondata") String jsondata) throws IOException {

		customer = objectMapper.readValue(jsondata, Customer.class);
		customer.setActive(Optional.ofNullable(customer.getActive()).orElse(false));
		return customerService.saveCustomerDetails(customer);

	}

}
