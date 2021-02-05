package com.ml.CustomersApi.controller;


import com.ml.CustomersApi.model.CustomerDTO;
import com.ml.CustomersApi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @PostMapping()
    public CustomerDTO addNewCustomer(@RequestBody CustomerDTO purchase){
        return service.addNewCustomer(purchase);
    }
    @GetMapping()
    public List<CustomerDTO> getCustomers(@RequestParam(required = false) String province){
        return service.getClients(province);
    }
}
