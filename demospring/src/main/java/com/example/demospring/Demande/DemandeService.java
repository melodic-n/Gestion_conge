package com.example.demospring.Demande;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;
import com.example.demospring.exepctions.SoldeExcpetion;


@Service
public class DemandeService {
	
	private final DemandeRepository emprep;
	
			@Autowired
		public DemandeService(DemandeRepository emprep) {
				this.emprep = emprep;
		}
	
		//voir status de demande 
		public List<Demande> voirdemande() {
				return emprep.findAll();
		}
		
		
		//creer demande 		
		public void createdemande( String motif ,
									Date date_debut, Date date_fin,
									Employe emp) throws SoldeExcpetion {
			
		
				if(motif == null|| date_debut == null || date_fin == null || emp == null)
				{
				    throw new IllegalArgumentException("All parameters must not be null");
				}
				
				Demande demande = new Demande(motif ,date_debut, date_fin, emp);
				if (demande.calculday()>demande.getEmp().getSoldeconge()) {
					throw new  SoldeExcpetion("Vous avez surpasser votre solde");
				}
				else if (demande.getEmp().getSoldeconge() == 0 ) {
					throw new  SoldeExcpetion("Vous n'avez aucun jour de conge");

				}
				else
					emprep.save(demande);
		
	
		}


	
		

}
