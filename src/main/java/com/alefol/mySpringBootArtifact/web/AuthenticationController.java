package com.alefol.mySpringBootArtifact.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;
import com.alefol.mySpringBootArtifact.security.JwtTokenFilter;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	JwtTokenFilter tokenFilter;
	
	@Autowired
	PersonneRepository personneRep;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneBean login() {
    	tokenFilter.doFilter(servletRequest, servletResponse, filterChain);
    	return null;
    }
    
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isLogged() {
    	//TODO implémenter vérification de la connexion
    	return true;
    }
}
