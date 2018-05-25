package com.alefol.mySpringBootArtifact.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.service.PersonneService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personne")
public class PersonneController {

    private static final Logger log = LoggerFactory.getLogger(PersonneController.class);
    
//    @Autowired
//    private ModelMapper modelMapper;

    @Autowired
    private PersonneService personneService;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PersonneBean> getAllPersonnes() {
        log.debug("Récupération de l'ensemble des personnes");
        return personneService.getAllPersonnes();
    }
    
    @RequestMapping(value = "/{personneId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneBean getById(@PathVariable("personneId") long id) {
		return personneService.getPersonneById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Long createPersonne(@RequestBody PersonneBean personne) {
    	return this.personneService.createPersonne(personne);
    }

}