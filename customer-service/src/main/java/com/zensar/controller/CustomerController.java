package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Customer;
import com.zensar.service.CustomerService;

@RestController
@RequestMapping(value = "/cutsomer-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	
	// http://localhost:7070/cutsomer-api/cusomer/101 --- to get the customer data with Id
	// @RequestMapping(value="/customer/{customerId}", method = RequestMethod.GET)
	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {

		return customerService.getCustomer(customerId);
	}

	// http://localhost:7070/cutsomer-api/customers -- to get all the data of the Customers
	// @RequestMapping(value="/customers, method = RequestMethod.GET)
	@GetMapping(value = { "/customers", "/listOfCustomers" })
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
		}

	// http://localhost:7070/cutsomer-api/customer -- to add the new customer data
	// @RequestMapping(value="/customer", method = RequestMethod.POST)
	@PostMapping("/customer")
	public void insertCustomer(@RequestBody Customer customer) {
		customerService.insertCustomer(customer);
		

	}

	// @RequestMapping(value="/cutsomer-api/customer/{customerId}", method =  RequestMethod.PUT)

	@PutMapping(value = "/customer/{customerId}")
	public void updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		 
		customerService.updateCustomer(customerId, customer);
	}

	// http://localhost:7070/cutsomer-api/customer -- to delete the customer.@RequestMapping(value="/customer/{customerId}", method =
	// RequestMethod.DELETE)

	@DeleteMapping(value = "/customer/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
	}

}
