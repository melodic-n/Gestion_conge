package com.example.demospring.Demande;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import com.example.demospring.Employe.Employe;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="demande")
@Inheritance(strategy = InheritanceType.JOINED)
public class  Demande {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		protected String status ;
		protected String motif ;
		protected Date date_debut;
		protected Date date_fin;
		  @ManyToOne
		    @JoinColumn(name = "emp") // This specifies the name of the foreign key column in the demande table
		    @JsonBackReference // Add this annotation
		  // This specifies the name of the foreign key column in the demande table
		 protected Employe emp ;
		
		  
				public Demande() {
					
					}

		public Demande( String motif ,Date date_debut, Date date_fin,
						Employe emp) {
					this.status = "en cours";
					this.motif = motif;
					this.date_debut = date_debut;
					this.date_fin = date_fin;
					this.emp = emp;
				}



		public String getStatus() {
			return status;
		}
		
		public Long calculday() {
			long diffmil = date_fin.getTime() - date_debut.getTime();
			return TimeUnit.DAYS.convert(diffmil, TimeUnit.MILLISECONDS);
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getMotif() {
			return motif;
		}

		public void setMotif(String motif) {
			this.motif = motif;
		}

		public Date getDate_debut() {
			return date_debut;
		}

		public void setDate_debut(Date date_debut) {
			this.date_debut = date_debut;
		}

		public Date getDate_fin() {
			return date_fin;
		}

		public void setDate_fin(Date date_fin) {
			this.date_fin = date_fin;
		}

		public Employe getEmp() {
			return emp;
		}

		public void setEmp(Employe emp) {
			this.emp = emp;
		}
		
		
		
		
		
		
		
		
		
		
}
