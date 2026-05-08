package com.example.ExceptionHandling.Service;

import com.example.ExceptionHandling.Entity.Customer;
import com.example.ExceptionHandling.Exception.NoSuchCustomerExistsException;
import com.example.ExceptionHandling.Exception.UserAlreadyExistsException;
import com.example.ExceptionHandling.Exception.UserEmailNotException;
import com.example.ExceptionHandling.Exception.UserNameNotFoundException;
import com.example.ExceptionHandling.Repository.CutomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    private CutomerRepo cutomerRepo;
    public Customer findByName(String name) throws UserNameNotFoundException {
        return cutomerRepo.findByName(name).orElseThrow(()->new UserNameNotFoundException());
    }
    public Customer findByEmail(String email) throws UserEmailNotException {
        return cutomerRepo.findByEmail(email).orElseThrow(()->new UserEmailNotException());
    }
    public Customer findByid(Long id) throws UserNameNotFoundException {
        return cutomerRepo.findById(id).orElseThrow(() -> new UserNameNotFoundException());
    }
    public List<Customer> findAll() {
        return cutomerRepo.findAll();
    }
    public String save(Customer customer) throws UserAlreadyExistsException {
        Optional<Customer> oldCustomer=cutomerRepo.findByName(customer.getName());
        if(!oldCustomer.isPresent()) {
            cutomerRepo.save(customer);
            return "Customer Added successfully";
        }
        else{
            throw new UserAlreadyExistsException();
        }

    }
    public void deleteById(Long id) {
        cutomerRepo.deleteById(id);
    }
    public String Update(Customer customer) throws NoSuchCustomerExistsException {
        Optional<Customer> oldCustomer=cutomerRepo.findByName(customer.getName());
        if(!oldCustomer.isPresent()) {
            throw new NoSuchCustomerExistsException();
        }
        else{
            oldCustomer.get().setAddress(customer.getAddress());
            oldCustomer.get().setEmail(customer.getEmail());
            oldCustomer.get().setName(customer.getName());
            cutomerRepo.save(oldCustomer.get());
            return "Customer Updated successfully";
        }
    }
}
