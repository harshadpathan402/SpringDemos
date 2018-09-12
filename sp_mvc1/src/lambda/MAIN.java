package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MAIN {
	
	public static void main(String[] args) {
		
		/**
		 * ::new is the function(constructor) reference to employee reference
		 * and that reference(ie function pointer) is passed in getEmployee's argument and 
		 * hence it creates anonymous function or construction
		 * call.    
		 */
		EmployeeFactory empFactory=Employee::new;
		Employee emp= empFactory.getEmployee("John Hammond", 25);
		System.out.println(emp);
		
		
		/**
		 * converting array of int primitive to Boxed type 
		 */
		int[] arr = IntStream.rangeClosed(1, 100).toArray();
		List<Integer> integers = Arrays.stream(arr)
									   .boxed()
									   .collect(Collectors.toList());
		
		/**
		 * Returns whether all elements of this stream match the provided predicate. 
		 * May not evaluate the predicate on all elements if not necessary for determining the result. 
		 * If the stream is empty then true is returned and the predicate is not evaluated.
		 */
		System.out.println("allMatch :: " +integers.stream().allMatch(value -> value % Integer.valueOf(2)==0));
		
		/**
		 * Returns a stream consisting of the elements of this stream that match the given predicate.
		 */
		String list = integers.stream().filter(value -> value % Integer.valueOf(2)==0)
						 .collect(Collectors.toList())
						 .toString();	    
		System.out.println(list);
		
		/**
		 * Returns whether any elements of this stream match the provided predicate. 
		 * May not evaluate the predicate on all elements if not necessary for determining the result. 
		 * If the stream is empty then false is returned and the predicate is not evaluated.
		 */
		System.out.println("anyMatch :: " + integers.stream().anyMatch(value -> value % Integer.valueOf(2)==0));
		
		
		/**
		 * Returns a stream consisting of the results of applying the given function to the elements of this stream.
		 */
		list = integers.stream().filter(value -> value % Integer.valueOf(2)==0)
						 .map(number -> number*2)
						 .collect(Collectors.toList())
						 .toString();
		System.out.println("map :: " + list);
		
		/**
		 * Count funtion with predicate
		 */
		long count =  integers.stream().filter(value -> value % Integer.valueOf(2)==0).count();
		System.out.println("Count :: "+ count);
		
		/**
		 * Filter + MAP + Collect
		 */
		List<Integer> even = integers.stream()
               					     .map(s -> Integer.valueOf(s))
                  					 .filter(number -> number % 2 == 0)
                  					 .collect(Collectors.toList());
		System.out.println("processed list, only even numbers: " + even);
		
		List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Harshad p", "Accounts", 8000));
        empList.add(new Employee("Nagesh Y", "Admin", 15000));
        empList.add(new Employee("Vasu V", "Security", 2500));
        empList.add(new Employee("Amar", "Entertainment", 12500));
 
        // find employees whose salaries are above 10000
        List<Employee> filteredList = empList.stream()
                                            .filter(employee -> employee.getSalary() > 10000)
                                            .collect(Collectors.toList());
 
        filteredList.forEach(System.out::println);
		

        
//    	Anonymous	class	instance	as	a	function	object	-	obsolete!
       Collections.sort(empList,	new	Comparator<Employee>()	{
        public	int	compare(Employee	s1,	Employee	s2)	{
        return	s1.getName().compareTo(s2.getName());
        }
        });
        
        
        empList.forEach(System.out::println);
        System.out.println("\n");
        
        //replacing above inner class
        Collections.sort(empList,(s1,s2) -> s1.getName().compareTo(s2.getName()));
        
        
        empList.forEach(System.out::println);
        
        
	}

	public static boolean isprime(Integer number){
		return number > 1 && IntStream.range(2, number)
									  .noneMatch(index -> number % index==0);
	}
	
}
