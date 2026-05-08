package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.SSecurity;
import com.example.SpringSecurity.Repository.SSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
@Component
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private SSRepository ssRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SSecurity security = ssRepository.findByUsername(username);

        return new User(security.getUsername(),security.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
}
