package com.example.demospring.RH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/rh")
public class RHController {
	
	private RHService rep ;

	@Autowired
	public RHController(RHService rep) {
		this.rep = rep;
	}
	
	//manager end point
	@PostMapping("/add")
	public void createemp(@RequestBody Employe emp) {
		rep.createRH( emp.getNom(), emp.getPrenom(), emp.getEmail(), emp.getMotdepass(), emp.getDept_id(), emp.getSoldeconge());

	}
	
	
	
	//workss
	@GetMapping("/all")
	public List<RH> getallemp() {
		return rep.findallrh();
	}
	
	
	
}
