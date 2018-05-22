package com.alefol.mySpringBootArtifact.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;

@RestController
 @RequestMapping("/auth")
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneBean login() {
    	// TODO implémenter controller de connexion
    	return null;
    }
    
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isLogged() {
    	//TODO implémenter vérification de la connexion
    	return true;
    }
}
