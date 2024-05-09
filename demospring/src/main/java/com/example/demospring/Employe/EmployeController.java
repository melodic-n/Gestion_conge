package com.example.demospring.Employe;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospring.exepctions.EmployeExistException;
import com.example.demospring.exepctions.NoCompteException;


@RestController
@RequestMapping("/employe")
public class EmployeController {

	private final EmployeService empser;
		@Autowired
	public EmployeController(EmployeService empser) {
		this.empser = empser;
	}
	 
	//works
	@PostMapping("/add")
	public void createemp(@RequestBody Employe emp) throws EmployeExistException {
		empser.createemployee( emp.getNom(), emp.getPrenom(), emp.getEmail(), emp.getMotdepass(), emp.getDept_id(), emp.getSoldeconge());

	}
	
	//works
	@PutMapping("/modify")
	public void modmanager(@RequestBody Employe emp) {
			empser.modifyemploye(emp.getId(), emp.getNom(), emp.getPrenom(), emp.getEmail(), emp.getMotdepass(), emp.getDept_id(), emp.getSoldeconge());
	}
	
	//works
	@DeleteMapping("/delete/{id}")
	public void deletemanager(@PathVariable Long id) throws NoCompteException {
		empser.deletecompte(id);
	}
	
	
	//works
	@GetMapping("/all")
	public List<Employe> getallemp() {
		return empser.findallemploye();
	}
	
	
	//works
	@GetMapping("/allsolde")
	public Map<String, Long> getallsolde() {
		return empser.voirsoldeall();
	}
	
	
	//works
	@GetMapping("/all/{id}")
	public Optional<Employe> getallempid(@PathVariable Long id) {
		return empser.findallemployeid(id);
	}
	
}
