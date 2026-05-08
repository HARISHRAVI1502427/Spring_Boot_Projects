package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.SSecurity;
import com.example.SpringSecurity.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody SSecurity  security){
        try{
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(security.getUsername(), security.getPassword()));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(Map.of("token",token));
        }
        catch (Exception e){

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Username or password incorrect"));
        }

    }

}
