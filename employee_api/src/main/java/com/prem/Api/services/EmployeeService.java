package com.prem.Api.services;

import java.util.List;

import com.prem.Api.Entity.Emplyee;

public interface EmployeeService {
     public Emplyee create(Emplyee emp);
     public Emplyee update(Emplyee emp,Integer id);
     public Emplyee read(Integer id);
     public List<Emplyee> read();
     public boolean delete(Integer id);
}
