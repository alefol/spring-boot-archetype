package com.alefol.mySpringBootArtifact.service;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.exceptions.ExceptionsMessages;
import com.alefol.mySpringBootArtifact.exceptions.ResourceNotFoundException;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;


/**
 * Created by MRomeh
 */
@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    @Transactional
    public void createPersonne(PersonneBean personne) {
        personneRepository.save(personne);
    }

    public List<PersonneBean> getAllPersonnes() {
    	return personneRepository.findAll();
    }
    
    public PersonneBean getPersonneById(long id) {
    	PersonneBean personneBean = personneRepository.findOne(id);
    	if(personneBean == null) {
    		throw new ResourceNotFoundException(MessageFormat.format(ExceptionsMessages.PERSONNE_NOT_FOUND, id));
    	}
    	return personneBean;
    }
    
    public PersonneBean getPersonneByEmail(String email) {
    	return personneRepository.findByEmail(email);
    }


}
