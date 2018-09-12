package lambda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@NumberFormat(style=Style.NUMBER)
	private Integer age;
	
    private String account;
    
    @NumberFormat(style=Style.NUMBER)
    private Integer salary;
    
    public Employee() {
		// TODO Auto-generated constructor stub
	}

	//Contructor of employee
	public Employee(String name, Integer age){
		this.name=name;
		this.age=age;
	}

    public Employee(String name, String account, Integer salary) {
        this.name = name;
        this.account = account;
        this.salary = salary;
    }
 
    public Employee(String name,Integer age, String account, Integer salary) {
        this.name = name;
        this.account = account;
        this.salary = salary;
        this.age=age;
    }
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAccount() {
        return account;
    }
 
    public void setAccount(String account) {
        this.account = account;
    }
 
    public Integer getSalary() {
        return salary;
    }
 
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, age=%s, account=%s, salary=%s]", id, name, age, account,
				salary);
	}

 

}
