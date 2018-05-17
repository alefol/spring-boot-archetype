package com.alefol.mySpringBootArtifact.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;
import com.alefol.mySpringBootArtifact.service.PersonneService;


@RestController
@RequestMapping("/application")
public class PersonneController {

    private static final Logger log = LoggerFactory.getLogger(PersonneController.class);

    @Autowired
    private PersonneService personneService;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PersonneBean> getAllPersonnes() {
        log.debug("Trying to retrieve all alerts");
        return personneService.getAllPersonnes();

    }

}