package com.alefol.mySpringBootArtifact.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alefol.mySpringBootArtifact.repository.PersonneRepository;
import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import java.util.List;


/**
 * Created by MRomeh
 */
@Service
public class PersonneService {
    private static final Logger log = LoggerFactory.getLogger(PersonneService.class);
    @Autowired
    private PersonneRepository personneRepository;

    @Transactional
    public void createPersonne(PersonneBean personne) {
        personneRepository.save(personne);
    }

    public List<PersonneBean> getAllPersonnes() {
      return (List<PersonneBean>)personneRepository.findAll();
    }


}
