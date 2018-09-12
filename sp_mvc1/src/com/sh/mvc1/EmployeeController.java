package com.sh.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lambda.Employee;
import lambda.EmployeeService;

@Controller
public class EmployeeController {
	
	@RequestMapping("/welcome")
	public String gotoPage1() {
		//...
		return "page1";
	}
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		System.out.println("employee ::: " + employee);
		new EmployeeService().addEmployee(employee);
		//...
		return "success";
	}
	
	@RequestMapping("/getEmployee")
	public String getEmployee(@RequestParam("employeeId") int id, Model model) {
		System.out.println(id);
		System.out.println(new EmployeeService().getEmployee(id));
		model.addAttribute("employee", new EmployeeService().getEmployee(id));
		//...
		return "page2";
	}
	
	@RequestMapping("/return")
	public String doLogin() {
		System.out.println("return called : ");
		return "redirect:/";
	}
	
	
	@ExceptionHandler(Exception.class)
    public ModelAndView handleLimitedQuantityException(Exception LQEx) {
    ModelAndView model = new ModelAndView("exception");
    model.addObject("exception", LQEx);
    return model;
	}
}
