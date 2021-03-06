package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Customer;
import com.zensar.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(int customerId) {
		
		return customerRepository.findById(customerId).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
		}

	@Override
	public void insertCustomer(Customer customer) {
		customerRepository.save(customer);		
	}

	@Override
	public void updateCustomer(int customerId, Customer customer) {
		
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		customerRepository.deleteById(customerId);
	}

}
