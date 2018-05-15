package com.alefol.mySpringBootArtifact.repository;

import org.springframework.data.repository.CrudRepository;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;

public interface PersonneRepository extends CrudRepository<PersonneBean, Long> {

}
