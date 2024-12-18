package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmpMgmtService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmpMgmtService empService;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@PostMapping("/search")
	public String searchData(@ModelAttribute("emp") Employee emp,
			                  Map<String,Object> map) {
		List<Employee> list =empService.showEmpDynamically(emp);
		map.put("list", list);
		return "show_result";
	}
	
	@GetMapping("/data") 
	public String showData(Map<String,Object> map,
			               @ModelAttribute("emp") Employee emp) {
		List<Employee> list =empService.showAllEmp();
		map.put("list", list);
		
		return "show_result";
	    }
	 
	
	@GetMapping("/add")
	public String showEmpForm(@ModelAttribute("emp") Employee emp) {
		//return LVN
		return "register_emp";
	}
	/*
	@PostMapping("/add")
	public String saveEmp(@ModelAttribute("emp") Employee emp,
			               Map<String,Object> map) {
		String msg=empService.registerEmployee(emp);
		List<Employee> list =empService.showAllEmp();
		
		map.put("msg", msg);
		map.put( "list", list);
		//return LVN
		return "show_result";
	}*/
	
	@PostMapping("/add")
	public String saveEmp(@ModelAttribute("emp") Employee emp,
			              RedirectAttributes attrs ) {
		String msg=empService.registerEmployee(emp);
		 
		
		attrs.addFlashAttribute("msg", msg);
		 
		//return LVN
		return "redirect:data";
	}
	
	@GetMapping("/edit")
	public String showEditForm(@RequestParam("no") int no,
			                   @ModelAttribute("emp") Employee emp) {
		//use Service
		Employee emp1=empService.getEmpByNo(no); 
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "update_emp";
	}
	
	@PostMapping("/edit")
	public String editEmp(@ModelAttribute("emp") Employee emp,
			              RedirectAttributes attrs) {
		String msg =empService.updateEmp(emp);
		attrs.addFlashAttribute("msg", msg);
		
		//return LVN
		return "redirect:data";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("no") int no, 
			              RedirectAttributes attrs) {
		String msg =empService.deleteEmp(no);
		attrs.addFlashAttribute("msg", msg);
		
		//return LVN
		return "redirect:data";
	}
	
	 
}
