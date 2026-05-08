package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.Entity.SSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSRepository extends JpaRepository<SSecurity, Long> {
    SSecurity findByUsername(String username);
}
