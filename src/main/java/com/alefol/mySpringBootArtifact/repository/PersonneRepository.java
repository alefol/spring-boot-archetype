package com.alefol.mySpringBootArtifact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alefol.mySpringBootArtifact.bean.PersonneBean;

public interface PersonneRepository extends JpaRepository<PersonneBean, Long> {

}
