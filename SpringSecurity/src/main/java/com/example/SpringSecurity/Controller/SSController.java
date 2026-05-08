package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.SSecurity;
import com.example.SpringSecurity.Service.SSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/api/security")
public class SSController {
    @Autowired
    private SSService ssService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/all")
    public List<SSecurity> getuser() {
        return ssService.findAll();
    }
    @GetMapping("/user/{id}")
    public SSecurity findById(@PathVariable Long id) {
        return ssService.findById(id);
    }
    @PostMapping("/insert")
    public SSecurity save(@RequestBody SSecurity security) {
        security.setPassword(passwordEncoder.encode(security.getPassword()));
        return ssService.save(security);
    }
    @PutMapping("/update/{id}")
    public SSecurity update(@RequestBody SSecurity security,@PathVariable Long id) {
        security.setPassword(passwordEncoder.encode(security.getPassword()));
        return ssService.update(id,security);
    }
    @DeleteMapping("/del/{id}")
    public void deleteById(Long id) {
        ssService.deleteById(id);
    }

}
