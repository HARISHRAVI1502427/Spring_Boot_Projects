package com.example.ExceptionHandling.Controller;

import com.example.ExceptionHandling.Entity.Customer;
import com.example.ExceptionHandling.Exception.NoSuchCustomerExistsException;
import com.example.ExceptionHandling.Exception.UserAlreadyExistsException;
import com.example.ExceptionHandling.Exception.UserEmailNotException;
import com.example.ExceptionHandling.Exception.UserNameNotFoundException;
import com.example.ExceptionHandling.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @GetMapping("/get/{id}")
    public Customer findById(@PathVariable Long id) throws UserNameNotFoundException {
        return customerService.findByid(id);
    }
    @PostMapping("/insert")
    public String insert(@RequestBody Customer customer) throws UserAlreadyExistsException {
        return customerService.save(customer);
    }
    @PutMapping("/update")
    public String update(@RequestBody Customer customer) throws NoSuchCustomerExistsException {
        return customerService.Update(customer);
    }
    @GetMapping("/name")
    public Customer findByName(@RequestParam String name) throws UserNameNotFoundException {
        return customerService.findByName(name);
    }
    @GetMapping("/email")
    public Customer findByEmail(@RequestParam String email) throws UserEmailNotException {
        return customerService.findByEmail(email);
    }
    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable Long id){
        customerService.deleteById(id);
        return "Deleted Customer with id: " + id;
    }

}
