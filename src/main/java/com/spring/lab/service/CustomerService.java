package com.spring.lab.service;

import com.spring.lab.DTO.CustomerDTo;
import com.spring.lab.DTO.Message;
import com.spring.lab.hateoas.HateoasData;
import com.spring.lab.model.CustomerModel;
import com.spring.lab.repository.CustomerRepository;
import com.spring.lab.util.MethodLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MethodLink methodLink;
    private final ApplicationContext applicationContext;
    private final CustomerModel customerModel;

    @Autowired
    public CustomerService(
            CustomerRepository customerRepository,
            MethodLink methodLink,
            ApplicationContext applicationContext,
            CustomerModel customerModel)
    {
        this.customerRepository = customerRepository;
        this.methodLink = methodLink;
        this.applicationContext = applicationContext;
        this.customerModel = customerModel;
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

    public HateoasData<Message> updateCustomerService(int id, CustomerDTo customerDTo){

        Message updateResponse = customerRepository.updateCustomer(id, customerDTo);

        // Create a new HateoasData instance for each request
        HateoasData<Message> hateoasData = applicationContext.getBean(HateoasData.class);

        hateoasData.setContent(updateResponse);
        hateoasData.addLink(methodLink.get(id));
        hateoasData.addLink(methodLink.delete(id));

        return hateoasData;
    }

    public Message deleteCustomerService(int id){
        Message deleteMessage = customerRepository.deleteCustomer(id);
        return deleteMessage;
    }

    public List<CustomerModel> findAllCustomerService(){
        List<CustomerModel> allCustomers = customerRepository.findAllCustomers();
        return allCustomers;
    }

}
