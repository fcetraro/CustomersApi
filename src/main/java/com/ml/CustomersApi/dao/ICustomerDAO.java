package com.ml.CustomersApi.dao;

import com.ml.CustomersApi.model.CustomerDTO;

import java.util.List;

public interface ICustomerDAO {
    CustomerDTO add(CustomerDTO customer);
    List<CustomerDTO> getCustomers(String filter);
    CustomerDTO getCustomerByEmail(String email);
}
