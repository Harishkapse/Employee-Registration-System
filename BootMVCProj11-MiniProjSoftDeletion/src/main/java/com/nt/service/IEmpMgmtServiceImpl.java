package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class IEmpMgmtServiceImpl implements IEmpMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	@Override
	public List<Employee> showAllEmp() {
		 
		return empRepo.findAll();
	}
	@Override
	public String registerEmployee(Employee emp) {
		 
		return "Employee is registered with empno: "+empRepo.save(emp).getEmpno();
	}
	@Override
	public Employee getEmpByNo(int eno) {
		 
		return empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
	}
	@Override
	public String updateEmp(Employee emp) {
		 
		return "Employee updated with empno: "+empRepo.save(emp).getEmpno();
	}
	@Override
	public String deleteEmp(int eno) {
		 empRepo.deleteById(eno);
		return "Employee deleted with EmpNO: "+eno;
	}
	@Override
	public List<Employee> showEmpDynamically(Employee emp) {
		 //set null value to empty string property
		if(emp.getEname().equalsIgnoreCase("")||emp.getEname().length()==0)
			emp.setEname(null);
		if(emp.getJob().equalsIgnoreCase("")||emp.getJob().length()==0)
			emp.setJob(null);
		// prepare example obj for emp
		Example example=Example.of(emp);
		//use repo
		List<Employee> list =empRepo.findAll(example);
		return list;
	}

}
