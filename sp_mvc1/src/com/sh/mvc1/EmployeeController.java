package com.sh.mvc1;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lambda.Employee;
import lambda.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		System.out.println("employee ::: " + employee);
		employeeService.addEmployee(employee);
		return "success";
	}
	
	@RequestMapping("/getEmployee")
	public String getEmployee(@RequestParam("employeeId") int id, Model model) {
		System.out.println(id);
		System.out.println(employeeService.getEmployee(id));
		model.addAttribute("employee", employeeService.getEmployee(id));
		return "employeeShow";
	}
	
	@RequestMapping("/return")
	public String doLogin() {
		System.out.println("return called : ");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}
	
	
	
	@RequestMapping("/getAllEmployees")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("employeeList");

        List<Employee> employeeList = employeeService.getAllEmployees();
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(employeeList);
        pagedListHolder.setPageSize(10);
        System.out.println("######### " + pagedListHolder.getPageCount());
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
        	page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("employeeList", pagedListHolder.getPageList());
        }
        
        return modelAndView;
    }
	
	/*@RequestMapping("/_getEmployee")
	public Model include(Model md){
		return md;
	}*/
	
	@ExceptionHandler(Exception.class)
    public ModelAndView handleLimitedQuantityException(Exception LQEx) {
    ModelAndView model = new ModelAndView("exception");
    model.addObject("exception", LQEx);
    return model;
	}
}
