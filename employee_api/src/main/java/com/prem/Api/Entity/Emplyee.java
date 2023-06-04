package com.prem.Api.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emplyee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empId")
	private int _employeeId;
	@Column(name="empName")
	private String _employeeName;
	@Column(name="empAdd")
	private String _employeeAddress;
	@Column(name="empAge")
	private int _employeeAge;
	public int get_employeeId() {
		return _employeeId;
	}
	public void set_employeeId(int _employeeId) {
		this._employeeId = _employeeId;
	}
	public String get_employeeName() {
		return _employeeName;
	}
	public void set_employeeName(String _employeeName) {
		this._employeeName = _employeeName;
	}
	public String get_employeeAddress() {
		return _employeeAddress;
	}
	public void set_employeeAddress(String _employeeAddress) {
		this._employeeAddress = _employeeAddress;
	}
	public int get_employeeAge() {
		return _employeeAge;
	}
	public void set_employeeAge(int _employeeAge) {
		this._employeeAge = _employeeAge;
	}
	public Emplyee(int _employeeId, String _employeeName, String _employeeAddress, int _employeeAge) {
		super();
		this._employeeId = _employeeId;
		this._employeeName = _employeeName;
		this._employeeAddress = _employeeAddress;
		this._employeeAge = _employeeAge;
	}
	public Emplyee() {
		super();
	}
	
}
