package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmpMgmtService {

	public List<Employee> showAllEmp();
	public String registerEmployee(Employee emp);
	public Employee getEmpByNo(int eno);
	public String updateEmp(Employee emp);
	public String deleteEmp(int eno);
	public List<Employee> showEmpDynamically(Employee emp);
}
