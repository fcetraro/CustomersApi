package com.ml.CustomersApi.dao.implementation;

import com.ml.CustomersApi.dao.ICustomerDAO;
import com.ml.CustomersApi.model.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class CustomerDAORepository implements ICustomerDAO {
    private static List<CustomerDTO> customers = new ArrayList<>();
    @Override
    public CustomerDTO add(CustomerDTO newReceipt) {
        customers.add(newReceipt);
        return customers.get(customers.size()-1);
    }

    private Predicate<CustomerDTO> getFilter(String filter){
        if(filter!=null) return customerDTO -> customerDTO.getProvince().equalsIgnoreCase(filter);
        return CustomerDTO -> true;
    }

    @Override
    public List<CustomerDTO> getCustomers(String filter) {
        return customers.stream().filter(getFilter(filter)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        for (CustomerDTO customer:customers) {
            if(customer.getEmail().equalsIgnoreCase(email)) return customer;
        }
        return null;
    }
}
