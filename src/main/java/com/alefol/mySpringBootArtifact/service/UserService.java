package com.alefol.mySpringBootArtifact.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;

@Service
public class UserService implements UserDetailsService  {
	
    private final PersonneRepository userRepository;
    
    @Autowired
    public UserService(PersonneRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
        PersonneBean personne = userRepository.findByEmail(email);
        
        if(personne == null) {
        	throw new UsernameNotFoundException("User not found");
        }
        

        return personne;
    }

}
