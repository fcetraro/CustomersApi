package com.ml.CustomersApi.service.implementation;

import com.ml.CustomersApi.dao.ICustomerDAO;
import com.ml.CustomersApi.exception.concreteExceptions.NotValidCustomerException;
import com.ml.CustomersApi.model.CustomerDTO;
import com.ml.CustomersApi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class CustomerServiceImplementation implements ICustomerService {
    @Autowired
    private ICustomerDAO customers;

    public boolean hasNullAttributes(CustomerDTO newCustomer){
        return Stream.of(newCustomer.getEmail(), newCustomer.getDni(), newCustomer.getProvince(),
                newCustomer.getPhone(), newCustomer.getFullName()).allMatch(Objects::isNull);
    }
    public void checkCustomer(CustomerDTO newCustomer) {
        try {
            if (hasNullAttributes(newCustomer)) {
               throw new Exception("Cliente con campos nulos");
            }
            if(customers.getCustomerByEmail(newCustomer.getEmail())!=null){
                throw new Exception("El email que trato de ingresar ya esta registrado");
            }
        }
        catch (Exception e)
        {
            throw new NotValidCustomerException("No se pudo ingresar al cliente, ver mensaje del error para mas " +
                    "detalles...", e);
        }
    }
    @Override
    public CustomerDTO addNewCustomer(CustomerDTO newCustomer) {
        checkCustomer(newCustomer);
        return customers.add(newCustomer);
    }

    @Override
    public List<CustomerDTO> getClients(String provinceFilter) {
        return customers.getCustomers(provinceFilter);
    }
}
