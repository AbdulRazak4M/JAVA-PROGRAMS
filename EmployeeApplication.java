// LinkedHashSet for Employee 
// avoid duplicate by using hascode and equals methods in Emploiyee class

import java.util.*;
class Employee
{
	int id;
	String name;
	double salary;
	
	//Dummy conmstructor
	Employee()
	{
		
	}
	// object intitlization
	Employee(int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	//overrid toStringMethod
	public String toString()
	{
		return "ID: "+this.id + "\tNAME: "+this.name + "\t SALARY: "+this.salary;
	}
	
	//override hashcode methods
	public int hashCode()
	{
		return (this.id*4336);
	}
	
	//overrid equals() methods
	public boolean equals(Object o)
	{
		if(o instanceof Employee)
		{
			Employee e1 = (Employee) o;
			if(this.id == e1.id && this.name.equals(e1.name) && this.salary == e1.salary)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
}
public class EmployeeApplication
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<Employee> lh = new LinkedHashSet<Employee>();
		
		Employee e1 = new Employee(1, "sohel", 1000);
		Employee e2 = new Employee(2, "omkar", 1000);
		Employee e3 = new Employee(1, "sohel", 1000);
		Employee e4 = new Employee(2, "omkar", 1000);
		Employee e5 = new Employee(3, "shubham", 1000);
		
		lh.add(e1);
		lh.add(e2);
		lh.add(e3);
		lh.add(e4);
		lh.add(e5);
		
		for(Employee e : lh)
		{
			System.out.println(e);
		}
	
		
		
	}
}

