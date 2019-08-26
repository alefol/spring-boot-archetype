package com.alefol.mySpringBootArtifact.web;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.service.PersonneService;
import com.alefol.mySpringBootArtifact.web.dto.PersonneDTO;


@RestController
@RequestMapping("/personne")
public class PersonneController {

    private static final Logger log = LoggerFactory.getLogger(PersonneController.class);
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonneService personneService;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PersonneDTO> getAllPersonnes() {
        log.debug("Récupération de l'ensemble des personnes");
        List<PersonneBean> listePersonnes = personneService.getAllPersonnes();
        return modelMapper.map(listePersonnes, new TypeToken<List<PersonneDTO>>() {}.getType());
    }
    
    @RequestMapping(value = "/{personneId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneDTO getById(@PathVariable("personneId") long id) {
		return modelMapper.map(personneService.getPersonneById(id), PersonneDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Long createPersonne(@RequestBody PersonneBean personne) {
    	personne.setAdmin(false);
    	return this.personneService.createPersonne(personne);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{personneId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePersonne(@PathVariable("personneId")Long personneId) {
    	this.personneService.deleteById(personneId);
    }
    
    @RequestMapping(value = "/email", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneDTO getByEmail(@RequestParam("email") String email) {
		return modelMapper.map(personneService.getPersonneByEmail(email), PersonneDTO.class);
    }

}