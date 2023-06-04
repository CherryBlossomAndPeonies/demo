package com.example.demo.customer;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> Get() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(String name, String email, Integer age) {}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest newCustomerRequest) {
        Customer customer = new Customer();
        customer.setAge(newCustomerRequest.age());
        customer.setEmail(newCustomerRequest.email());
        customer.setName(newCustomerRequest.name());

        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void editCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest newCustomerRequest) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.setAge(newCustomerRequest.age());
        customer.setEmail(newCustomerRequest.email());
        customer.setName(newCustomerRequest.name());

        customerRepository.save(customer);
    }
}
