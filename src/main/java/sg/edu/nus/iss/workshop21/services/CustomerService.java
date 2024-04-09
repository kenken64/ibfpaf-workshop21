package sg.edu.nus.iss.workshop21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop21.model.Customer;
import sg.edu.nus.iss.workshop21.model.Orders;
import sg.edu.nus.iss.workshop21.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public List<Customer> getAllCustomerWithPagination(int limit, int offset){
        return customerRepository.getAllCustomerWithPagination(limit, offset);
    }

    public Customer getCustomerById(int id){
        return customerRepository.getCustomerById(id);
    }

    public List<Orders> getCustomerByOrders(int id){
        return customerRepository.getCustomerByOrders(id);
    }

}
