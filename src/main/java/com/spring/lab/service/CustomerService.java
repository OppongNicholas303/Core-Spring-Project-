package com.spring.lab.service;

import com.spring.lab.hateoas.HateoasData;
import com.spring.lab.model.CustomerModel;
import com.spring.lab.repository.CustomerRepository;
import com.spring.lab.util.MethodLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MethodLink methodLink;
    private final ApplicationContext applicationContext;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, MethodLink methodLink, ApplicationContext applicationContext) {
        this.customerRepository = customerRepository;
        this.methodLink = methodLink;
        this.applicationContext = applicationContext;
    }

    public HateoasData<CustomerModel> saveCustomer (CustomerModel customerModel){
        CustomerModel customer = customerRepository.save(customerModel);

        // Create a new HateoasData instance for each request
        HateoasData<CustomerModel> hateoasData = applicationContext.getBean(HateoasData.class);

        MethodLink methodLink1 = new MethodLink();
        hateoasData.setContent(customer);
        hateoasData.addLink(methodLink1.put(customer.getId()));
        hateoasData.addLink(methodLink1.delete(customer.getId()));
        hateoasData.addLink(methodLink1.get(customer.getId()));

        return hateoasData;

    }

}
