package com.example.ExceptionHandling.Repository;

import com.example.ExceptionHandling.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CutomerRepo extends JpaRepository<Customer,Long> {
    public Optional<Customer> findByName(String name);
    public Optional<Customer> findByEmail(String email);
}
