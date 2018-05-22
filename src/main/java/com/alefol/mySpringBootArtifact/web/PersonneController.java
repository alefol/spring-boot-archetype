package com.alefol.mySpringBootArtifact.web;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        return personneService.getAllPersonnes().stream()
        		.map(personneBean -> modelMapper.map(personneBean, PersonneDTO.class)).collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/{personneId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonneDTO getById(@PathVariable("personneId") long id) {
		return modelMapper.map(personneService.getPersonneById(id), PersonneDTO.class);
    }

}