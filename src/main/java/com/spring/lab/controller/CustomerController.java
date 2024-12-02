package com.spring.lab.controller;

import com.spring.lab.DTO.CustomerDTo;
import com.spring.lab.DTO.Message;
import com.spring.lab.hateoas.HateoasData;
import com.spring.lab.model.CustomerModel;
import com.spring.lab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer") // Base path for customer-related endpoints
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public HateoasData<CustomerModel> saveCustomer(@RequestBody CustomerModel customerModel) {
        return customerService.saveCustomer(customerModel);
    }

    @PutMapping("/{id}")
    public HateoasData<Message> update (
            @PathVariable String id,
            @RequestBody CustomerDTo customerDTo
            ){
        return customerService.updateCustomerService(Integer.parseInt(id), customerDTo);
    }

    @DeleteMapping("/{id}")
    public Message delete(
           @PathVariable String id
    ){
        return customerService.deleteCustomerService(Integer.parseInt(id));
    }

    @GetMapping("/")
    public List<CustomerModel> findAllCustomers() {
        return customerService.findAllCustomerService();
    }

}
