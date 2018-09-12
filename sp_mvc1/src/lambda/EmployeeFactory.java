package lambda;

public interface EmployeeFactory {
	
	public abstract Employee getEmployee(String name, Integer age);

}
