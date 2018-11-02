package com.alefol.mySpringBootArtifact.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.exceptions.ExceptionsMessages;
import com.alefol.mySpringBootArtifact.exceptions.FieldMissingException;
import com.alefol.mySpringBootArtifact.exceptions.ResourceNotFoundException;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;


@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    @Transactional
    public Long createPersonne(PersonneBean personne) {
    	if(personne == null || personne.getEmail() == null) {
    		throw new FieldMissingException(ExceptionsMessages.PERSONNE_FIELD_MISSING);
    	}
		return personneRepository.save(personne).getId();
    }

    public List<PersonneBean> getAllPersonnes() {
    	return personneRepository.findAll();
    }
    
    public PersonneBean getPersonneById(long id) {
    	Optional<PersonneBean> personneBean = personneRepository.findById(id);
    	if(!personneBean.isPresent()) {
    		throw new ResourceNotFoundException(MessageFormat.format(ExceptionsMessages.PERSONNE_NOT_FOUND, id));
    	}
    	return personneBean.get();
    }
    
    public void deleteById(Long id) {
    	if(id != null) {
    		this.personneRepository.deleteById(id);
    	}
    }

    public PersonneBean getPersonneByEmail(String email) {
    	return personneRepository.findByEmail(email);
    }

}
