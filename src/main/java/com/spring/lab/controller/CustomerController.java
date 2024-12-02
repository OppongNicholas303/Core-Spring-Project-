package com.spring.lab.controller;

import com.spring.lab.hateoas.HateoasData;
import com.spring.lab.model.CustomerModel;
import com.spring.lab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers") // Base path for customer-related endpoints
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
}
