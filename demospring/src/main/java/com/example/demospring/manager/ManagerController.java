package com.example.demospring.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospring.Employe.Employe;



@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	private final ManagerService man;

	public ManagerController(ManagerService man) {
		this.man = man;
	}
	//works
		@PostMapping("/add")
		public void createemp(@RequestBody Employe emp) {
			man.createmanager( emp.getNom(), emp.getPrenom(), emp.getEmail(), emp.getMotdepass(), emp.getDept_id(), emp.getSoldeconge());

		}

		//works
		@GetMapping("/all")
		public List<Manager> getallemp() {
			return man.findallmanager();
		}
		

}

