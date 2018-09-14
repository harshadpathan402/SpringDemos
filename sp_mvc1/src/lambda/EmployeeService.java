package lambda;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	public static SessionFactory factory; 
	private ManageEmployee manageEmployee;
	
	public EmployeeService() {
		init();
		manageEmployee = new ManageEmployee();
	}
	public void init(){
		   try {
		         factory = new Configuration().configure().buildSessionFactory();
		      } catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
	}

	public void addEmployee(Employee employee) {
		manageEmployee.addEmployee(employee);
	}
	
	public Employee getEmployee(Integer employeeId) {
	      return manageEmployee.getEmployee(employeeId);
	}
	
	
	public List<Employee> getAllEmployees() {
	      return manageEmployee.getAllEmployees();
	}
}
