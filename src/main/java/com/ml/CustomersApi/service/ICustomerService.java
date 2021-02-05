package com.ml.CustomersApi.service;

import com.ml.CustomersApi.model.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO addNewCustomer(CustomerDTO newCustomer);
    List<CustomerDTO> getClients(String provinceFilter);
}
