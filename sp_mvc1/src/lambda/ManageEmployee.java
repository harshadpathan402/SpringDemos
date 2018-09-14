package lambda;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ManageEmployee {
	  private Session session;
		
	  public void open() {
			session = HbUtil.getSessionFactory().openSession();
		}
	
	   /* Method to CREATE an employee in the database */
	   public Integer addEmployee(String name, Integer age, String account, Integer salary){
	     
	      Transaction tx = null;
	      Integer employeeID = null;
	      try {
	    	 open();
	         tx = session.beginTransaction();
	         Employee employee = new Employee();
	         employee.setAccount(account);
	         employee.setAge(age);
	         employee.setName(name);
	         employee.setSalary(salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	   
	   /* Method to CREATE an employee in the database */
	   public Integer addEmployee(Employee employee){
	     
	      Transaction tx = null;
	      Integer employeeID = null;
	      try {
	    	 open();
	         tx = session.beginTransaction();
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	   
	   
	   /* Method to get an employee in the database */
	   public Employee getEmployee(Integer employeeID){
		   Employee employee = null;
	      Transaction tx = null;
	      try {
	    	 open();
	         tx = session.beginTransaction();
	         employee = (Employee)session.get(Employee.class, employeeID);
	         tx.commit();
	      }catch (NumberFormatException e) {
		         if (tx!=null) tx.rollback();
		         e.getMessage(); 
	      } 
	      catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.getCause(); 
	      } finally {
	         session.close(); 
	      }
	      return employee;
	   }
	   
	   
	   /* Method to get all employees in the database */
	   public List<Employee> getAllEmployees(){
		   List<Employee> employees = null;
	      Transaction tx = null;
	      try {
	    	 open();
	         tx = session.beginTransaction();
	         Query query = session.createQuery("from Employee");
	         employees =   query.list();
	         tx.commit();
	      }catch (NumberFormatException e) {
		         if (tx!=null) tx.rollback();
		         e.getMessage(); 
	      } 
	      catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.getCause(); 
	      } finally {
	         session.close(); 
	      }
	      return employees;
	   }
	   
}
