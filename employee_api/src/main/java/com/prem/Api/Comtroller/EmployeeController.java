package com.prem.Api.Comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prem.Api.Entity.Emplyee;
import com.prem.Api.services.EmployeeService;

@RestController
public class EmployeeController {
 
	
	public EmployeeService empService;
	@Autowired
	public EmployeeController(EmployeeService emp) {
		this.empService=emp;
	}
   
	
	@GetMapping("api/employee")
	public ResponseEntity<List<Emplyee>> getAllEmployee(){
		 List<Emplyee> emp=empService.read();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping("api/employee")
	public ResponseEntity<Emplyee> postEmployee(@RequestBody Emplyee emp){
		
		return new ResponseEntity<>(empService.create(emp),HttpStatus.CREATED);
	}
	@GetMapping("api/employee/{id}")
	public ResponseEntity<Emplyee> getEmployee(@PathVariable Integer id){
		 Emplyee emp=empService.read(id);
		 if(emp==null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
		 else {
			 return new ResponseEntity<>(emp,HttpStatus.OK); 
		 }
		
	}
	@PutMapping("api/employee/{id}")
	public ResponseEntity<Emplyee> updateEmployee(@RequestBody Emplyee emp,@PathVariable Integer id){
		Emplyee employee=empService.update(emp, id);
		if(employee==null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
		 else {
			 return new ResponseEntity<>(emp,HttpStatus.OK); 
		 }
	}
	@DeleteMapping("api/employee/{id}")
	public ResponseEntity<Emplyee> deleteEmployee(@PathVariable Integer id){
		Boolean emp=empService.delete(id);
		if(emp) {
			 return new ResponseEntity<>(HttpStatus.OK); 
		 }
		 else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
	}
	
}
