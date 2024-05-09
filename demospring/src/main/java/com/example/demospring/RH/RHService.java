package com.example.demospring.RH;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demospring.departement.Departement;
import com.example.demospring.manager.Manager;



@Service
public class RHService {
	
			private final RHRepository rhrep;
		    private final BCryptPasswordEncoder bCryptPasswordEncoder;

			@Autowired
			public RHService(RHRepository rhrep, BCryptPasswordEncoder bCryptPasswordEncoder) {
				this.rhrep = rhrep;
				this.bCryptPasswordEncoder = bCryptPasswordEncoder;
			}
			
			
			  public String encrytpass(String pass) { 
				  return
			  bCryptPasswordEncoder.encode(pass); }
			 
				 
	       //create comtpe
			public  void createRH(String nom,String prenom,String email, String motdepass,Departement dept, Long solde) {
				RH empp = new RH( nom, prenom, email, encrytpass(motdepass),solde ,dept);//addhash
				rhrep.save(empp);
			}

			
				public List<RH> findallrh(){
					return rhrep.findAll();
				}
				
				public Optional<RH> findallrhid(Long id){
					return rhrep.findById(id);
				}
				
				

}
