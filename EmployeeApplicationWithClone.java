// Question 1
/* WAP to create the class as Employee with fields id,name,salary
 * 1) create object clone Employee class
 * 2) override toString() method
 * 3) sort Employees by Salary
 * 4)find the max Salary
 */

import java.util.*;

class Employee implements Cloneable
{
	private int id;
	private String name;
	private double salary;
	
	// create dummy Constructor
	Employee()
	{
		System.out.println("Please Enter the valid Employee Information");
	}
	Employee(int id, String name, double salary)
	{
		this.id =id;
		this.name = name;
		this.salary =salary;
	}
	public double getSalary()
	{
		return salary;
	}
	//override toString() method for proper output 
	public String toString()
	{
		return "ID: "+ id +"\tNAME: "+name+"\tSALARY: "+salary;
	}
	// Override clone() method
	public Object clone() throws CloneNotSupportedException
	{
		// to call Object class clone method which is shallow cloning
		return super.clone();
	}
}

public class EmployeeApplication {

	public static void main(String[] args) throws CloneNotSupportedException {
		// create ArrayList
		ArrayList<Employee> al = new ArrayList<Employee>();
		// employee 1
		Employee e1 = new Employee(1,"RAM",10000);
		//employee 2
		Employee e2 = new Employee(2, "SHYAM", 70000);
		//employee 3
		Employee e3 = new Employee(3, "DINESH", 20000);
		//employee 4
		Employee e4 = new Employee(4, "GANESH", 50000);
		
		//creating cloned Object of employee 1
		Employee e5 = (Employee) e1.clone();
		
		al.add(e1);
		al.add(e2);
		al.add(e3);
		al.add(e4);
		al.add(e5);
		//System.out.println(e1.hashCode());
		//System.out.println(e5.hashCode());
		
		
		System.out.println("BEFORE SORTING");
		System.out.println("-----------------------------------------------------------------\n");
		showEmployee(al);
		
		// Sorting Employee by Salary
		Collections.sort(al,new MyComparator());
		
		System.out.println("\n---------------------------------------------------------------\n");
		System.out.println("AFTER SORTING BY SALARY");
		System.out.println("\n---------------------------------------------------------------\n");
		showEmployee(al);
		
		// Find Max Salary Employee
		System.out.println("\n---------------------------------------------------------------\n");
		System.out.println("Employee With Max Salary:");
		System.out.println("\n---------------------------------------------------------------\n");
		double maxSal = findMax(al);
		for(Employee e : al)
		{
			if(e.getSalary() == maxSal)
			{
				System.out.println(e);
			}
		}
	}
	
	//show method
	public static void showEmployee(ArrayList<Employee> al)
	{
		Iterator<Employee> i = al.iterator();
		while(i.hasNext())
		{
			Employee e =  i.next();
			System.out.println(e);
		}
	}
	
	// find max Salary Employee
	public static double findMax(ArrayList<Employee> al)
	{
		double max = 0;
		Iterator<Employee> i = al.iterator();
		while(i.hasNext())
		{
			Employee e = (Employee)i.next();
			if(e.getSalary() > max)
			{
				max = e.getSalary();
			}
		}
		return max;
	}
}

//for Manual Sorting
class MyComparator implements Comparator<Employee>
{

	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		//Employee e1 = (Employee) o1;
		//Employee e2 = (Employee) o2;
		if(e1.getSalary() > e2.getSalary())
			return 1;
		else 
			return -1;
	}

}
