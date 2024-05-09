package com.example.demospring.Employe;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demospring.departement.Departement;
import com.example.demospring.exepctions.EmployeExistException;
import com.example.demospring.exepctions.NoCompteException;

@Service
public class EmployeService {
	
	@Autowired
	private final EmployeRepository emp;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public EmployeService(EmployeRepository emp, BCryptPasswordEncoder bCryptPasswordEncoder) {
			this.emp = emp;
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}
	
	   // get all employee
		public List<Employe> findallemploye(){
			return emp.findAll();
		}
		
		
	   //get  one specific employe
		public Optional<Employe> findallemployeid(Long id){ // i could turn into oBject type Employe 
			return emp.findById(id);
		}
		
		
		  public String encrytpass(String pass) { return
		  bCryptPasswordEncoder.encode(pass); }
		 
			 
		//create comtpe
		public  void createemployee(String nom,String prenom,
									String email, String motdepass,
									Departement dept,Long solde) throws EmployeExistException {
			
			  if (nom == null || prenom == null || email == null || motdepass == null || solde == null) {
		            throw new IllegalArgumentException("All parameters must not be null");
		        }
			  List<Employe> emps = emp.findAll();

				 boolean exists= false;
			  for (Employe employe : emps) {
				if(employe.getEmail().equals(email))
						exists= true;
			}
			 if(!exists) {
			Employe empp = new Employe( nom, prenom, email, encrytpass(motdepass), dept, solde);//addhash
			emp.save(empp);
			 } else
				 throw new EmployeExistException("Cet employe deja exist");
			 
		}
		
		public void modifyemploye(Long id,String nom,String prenom,String email, String motdepass,Departement dept, Long solde) throws NoSuchElementException {
			
			try {
				
				Optional<Employe> empmod = emp.findById(id);
				
				if(nom == null) {
					nom=empmod.get().getNom();
					empmod.get().setNom(nom);
				}
				else {
					empmod.get().setNom(nom);
				}
				
				if (prenom ==  null) {
					prenom = empmod.get().getPrenom();
					empmod.get().setPrenom(prenom);
				} else {
					empmod.get().setPrenom(prenom);
				}
				
				if (email == null) {
					email = empmod.get().getEmail();
					empmod.get().setEmail(email);
				
				} else {
					empmod.get().setEmail(email);
				}
				if (motdepass == null) {
					motdepass = empmod.get().getMotdepass();
					empmod.get().setMotdepass(encrytpass(motdepass));//add hash
				} else {
					empmod.get().setMotdepass(encrytpass(motdepass));
				}
				
				if (dept == null) {
					dept = empmod.get().getDept_id();
					empmod.get().setDept_id(dept);	

				} else {
					empmod.get().setDept_id(dept);
				}
				if (solde == null) {
					solde = empmod.get().getSoldeconge();
					empmod.get().setSoldeconge(solde);
				} else {
					empmod.get().setSoldeconge(solde);
				}
				
				emp.save(empmod.get());
				
			}catch (NullPointerException p ) {
					p.getMessage();
			}
			
		}
			//supprimmer
			public void deletecompte(Long id) throws NoCompteException  {
				emp.deleteById(id);
			}
			

			public Long voirsolde(Long id) {
				Optional<Employe> empl = emp.findById(id);
				if(empl.isEmpty() ) {
					Employe rh = empl.get();
					return rh.getSoldeconge();
					}
					throw new NoSuchElementException("Cet employée n'exist pas ");
			}
			
			
			// if a year passes from creating the profile all soldes should reset to 0
			 public void expiresolde (Employe empl) {
				 if(LocalDate.now().getDayOfMonth() == 1 && LocalDate.now().getMonthValue() == 1) {
					 empl.setSoldeconge((long) 0);
				 }
			 }

				
			public Map<String, Long> voirsoldeall() {
				List<Employe> empl=emp.findAll();
				Map<String, Long> solde = new HashMap<String, Long>();
				for (Employe emp : empl) {
					Employe rh = emp;
					solde.put(rh.getNomPrenom(),rh.getSoldeconge());
				}
				return solde;
			}

	
	
	
}
