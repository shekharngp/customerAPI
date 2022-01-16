package com.customer.jpa.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.jpa.tutorial.entity.Customer;
import com.customer.jpa.tutorial.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomerDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	/*
	 * @Override public List<Customer> fetchCustomerList() { return
	 * customerRepository.findAll(); }
	 * 
	 * @Override public Customer fetchCustomerById(Long customerId) throws
	 * CustomerNotFoundException {
	 * 
	 * Optional<Customer> customerDetails = customerRepository.findById(customerId);
	 * 
	 * if (!customerDetails.isPresent()) { throw new
	 * CustomerNotFoundException("No customer found with id: " + customerId); }
	 * 
	 * return customerDetails.get(); }
	 * 
	 * @Override public void deleteCustomerById(Long customerId) {
	 * customerRepository.deleteById(customerId); }
	 */

}
