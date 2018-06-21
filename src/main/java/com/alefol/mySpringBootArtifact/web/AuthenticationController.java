package com.alefol.mySpringBootArtifact.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;
import com.alefol.mySpringBootArtifact.security.JwtTokenFilter;
import com.alefol.mySpringBootArtifact.security.JwtTokenProvider;
import com.alefol.mySpringBootArtifact.web.dto.UserDTO;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenFilter tokenFilter;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	PersonneRepository personneRep;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String login(@RequestBody UserDTO user) {
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword())
    	);
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	String jwt = tokenProvider.createToken(authentication);
    	
    	return jwt;	
    }
    
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isLogged(HttpServletRequest request) {
    	return true;
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public double inscription(@RequestBody PersonneBean personne) {
    	String password = passwordEncoder.encode(personne.getPassword());
    	personne.setPassword(password);
    	return this.personneRep.save(personne).getId();
    }
    
}
