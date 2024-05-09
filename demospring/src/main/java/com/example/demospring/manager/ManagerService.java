package com.example.demospring.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demospring.Employe.Employe;
import com.example.demospring.Employe.EmployeRepository;
import com.example.demospring.departement.Departement;


@Service
public class ManagerService {

	@Autowired
	private final ManagerRepository manager;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;


	public ManagerService(ManagerRepository emp, BCryptPasswordEncoder bCryptPasswordEncoder ) {
			this.manager = emp;
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	// get manager
		public List<Manager> findallmanager(){
			return manager.findAll();
		}
		
		public Optional<Manager> findallmanagerid(Long id){
			return manager.findById(id);
		}
		
		
		  public String encrytpass(String pass) { return
		  bCryptPasswordEncoder.encode(pass); }
		 
			 
		
		//create comtpe
		public  void createmanager(String nom,String prenom,String email, String motdepass, Departement dept,Long solde) {
			  if (nom == null || prenom == null || email == null || motdepass == null || solde == null) {
		            throw new IllegalArgumentException("All parameters must not be null");
		        }
			Manager empp = new Manager( nom, prenom, email,encrytpass(motdepass), dept, solde); //addhash
			manager.save(empp);
		}
		
		
		
}
