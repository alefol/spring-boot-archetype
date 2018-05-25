package com.alefol.mySpringBootArtifact.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity()
@Table(name = "PERSONNE")
public class PersonneBean {

	@Id
	@SequenceGenerator(name="personne_generator", sequenceName = "personne_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personne_generator")
	private Long id; 
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
