package com.prem.Api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prem.Api.Entity.Emplyee;
import com.prem.Api.Repository.EmployeeRepository;
import com.prem.Api.services.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	  @Autowired
	  public EmployeeRepository empRepo;
      
	  public EmployeeServiceimpl(EmployeeRepository empRepo) {
		  this.empRepo=empRepo;
	  }
	@Override
	public Emplyee create(Emplyee emp) {		
		return empRepo.save(emp);
	}

	@Override
	public Emplyee update(Emplyee emp, Integer id) {
		   Optional<Emplyee> employee=empRepo.findById(id);
		   if(employee.isPresent()) {
			   employee.get().set_employeeName(emp.get_employeeName());
			   employee.get().set_employeeAddress(emp.get_employeeAddress());
			   employee.get().set_employeeAge(emp.get_employeeAge());
			   return empRepo.save(employee.get());
		   }
		   else {
			   return null;
		   }
		
	}

	@Override
	public Emplyee read(Integer id) {
		 Optional<Emplyee> employee=empRepo.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }
		 else {
			 return null;
		 }
	}

	@Override
	public List<Emplyee> read() {
		 List<Emplyee> employee=empRepo.findAll();
		return employee;
	}

	@Override
	public boolean delete(Integer id) {
		 Optional<Emplyee> employee=empRepo.findById(id);
		 if(empRepo.existsById(id)) {
			  empRepo.deleteById(id);
			  return true;
		 }
		 else {
			 return false;
		 }
	}
}
