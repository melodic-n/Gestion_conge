package com.example.demospring.Employe;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.demospring.Conge.Conge;
import com.example.demospring.Demande.Demande;
import com.example.demospring.departement.Departement;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")

public  class Employe {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected Long id ;
		protected String nom;
		protected String prenom;
		protected String email;
		protected String motdepass;
	    @ManyToOne
	    @JoinColumn(name = "dept_id") // many employes to one departemebt
	    @JsonBackReference // Add this annotation
		protected Departement dept_id;
		protected Long Soldeconge;
		@OneToMany (mappedBy = "emp")
		protected List<Demande> demandes;
		@OneToMany(mappedBy="emp")
		
		protected List<Conge> conges;
		protected LocalDate created_at;
		
		public Employe() {
}

			public String getNomPrenom() {
				return this.nom + " " +this.prenom;
			}
			
		public Employe(String nom, String prenom, String email, String motdepass, Departement dept_id,
				Long soldeconge) {
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.motdepass = motdepass;
			this.dept_id = dept_id;
			Soldeconge = soldeconge;
			this.created_at  = LocalDate.now();
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

		public String getMotdepass() {
			return motdepass;
		}

		public void setMotdepass(String motdepass) {
			this.motdepass = motdepass;
		}
		
		
		

		public List<Demande> getDemandes() {
			return demandes;
		}

		public void setDemandes(List<Demande> demandes) {
			this.demandes = demandes;
		}

		public List<Conge> getConges() {
			return conges;
		}

		public void setConges(List<Conge> conges) {
			this.conges = conges;
		}

		public LocalDate getCreated_at() {
			return created_at;
		}

		public void setCreated_at(LocalDate created_at) {
			this.created_at = created_at;
		}

		public Departement getDept_id() {
			return dept_id;
		}

		public void setDept_id(Departement dept_id) {
			this.dept_id = dept_id;
		}

		public Long getSoldeconge() {
			return Soldeconge;
		}

		public void setSoldeconge(Long newsolde) {
			Soldeconge = newsolde;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	
	
}
