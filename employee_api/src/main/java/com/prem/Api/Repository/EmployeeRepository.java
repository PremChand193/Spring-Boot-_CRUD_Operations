package com.prem.Api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.Api.Entity.Emplyee;

public interface EmployeeRepository extends JpaRepository<Emplyee, Integer>{
         
}
