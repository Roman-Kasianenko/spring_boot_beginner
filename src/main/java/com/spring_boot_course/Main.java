package com.spring_boot_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name, String email, Integer age
    ) {}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest newCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(newCustomerRequest.name);
        customer.setEmail(newCustomerRequest.email);
        customer.setAge(newCustomerRequest.age);

        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest newCustomerRequest) {

        Customer customer = customerRepository.getById(id);
        if (newCustomerRequest.name != null) {
            customer.setName(newCustomerRequest.name);
        }

        if (newCustomerRequest.email != null) {
            customer.setEmail(newCustomerRequest.email);
        }

        if (newCustomerRequest.age != null) {
            customer.setAge(newCustomerRequest.age);
        }
        customerRepository.save(customer);
    }

}
