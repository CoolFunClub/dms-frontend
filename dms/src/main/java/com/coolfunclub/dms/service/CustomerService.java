package com.coolfunclub.dms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.coolfunclub.dms.model.Customer;
import com.coolfunclub.dms.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //Constructor
    public CustomerService(){

    }

    public ResponseEntity<String> addCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getDriverLicenseID());
        if (existingCustomer.isPresent()){
            return ResponseEntity.badRequest().body("Customer already exists with the provided driver license ID.");
        } else{
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer added successfully");
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new LinkedList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public void deleteCustomer(String driverLic) {
        customerRepository.deleteById(driverLic);
    }

    public Customer getCustomerById(String driverLic) {
        return customerRepository.findById(driverLic).orElse(null);
    }

    public void updateCustomer(Customer updatedCustomer) {
            customerRepository.save(updatedCustomer);
     }

}

