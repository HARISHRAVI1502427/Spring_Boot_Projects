package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.SSecurity;
import com.example.SpringSecurity.Repository.SSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class SSService {
    @Autowired
    private SSRepository ssRepository;
    public SSecurity findById(Long id) {
        return ssRepository.findById(id).get();
    }
    public List<SSecurity> findAll(){
        return ssRepository.findAll();
    }
    public SSecurity save(SSecurity security) {
        return ssRepository.save(security);
    }
    public void deleteById(Long id) {
        ssRepository.deleteById(id);
    }
    public SSecurity update(Long id,SSecurity security) {
        security.setId(id);
        return ssRepository.save(security);
    }
}
