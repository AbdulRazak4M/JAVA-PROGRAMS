//Question 2
/*
 * Map within Map
 * 1)search Employee by id
 * 2)delete Employee by ID
 */

import java.util.*;

class Employee {
	private int id;
	private String name;
	private double salary;
	private String qual;

	// create dummy Constructor
	Employee() {
		System.out.println("Please Enter the valid Employee Information");
	}

	Employee(int id, String name, double salary, String qual) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.qual = qual;
	}

	public int getId() {
		return id;
	}

	// override toString() method for proper output
	public String toString() {
		return "ID: " + id + "\tNAME: " + name + "\tSALARY: " + salary + "\t\tQUALIFICATION: " + qual;
	}
}

public class MapWithMapApp {

	public static void main(String[] args) {

		// create first internal map
		LinkedHashMap<Integer, Employee> mi1 = new LinkedHashMap<Integer, Employee>();
		LinkedHashMap<Integer, Employee> mi2 = new LinkedHashMap<Integer, Employee>();

		// create Employee Objects
		// employee 1
		Employee e1 = new Employee(1, "RAM", 10000, "Developer");
		// employee 2
		Employee e2 = new Employee(2, "SHYAM", 70000, "Developer");
		// employee 3
		Employee e3 = new Employee(3, "DINESH", 20000, "Testing");
		// employee 4
		Employee e4 = new Employee(4, "GANESH", 50000, "Testing");
		mi1.put(1, e1);
		mi1.put(2, e2);
		mi2.put(3, e3);
		mi2.put(4, e4);

		// create outer map with department as key
		LinkedHashMap<String, Map> mo = new LinkedHashMap<String, Map>();
		mo.put("Dev", mi1);
		mo.put("Testing", mi2);

		do {
		System.out.println("Operatios:");
		System.out.println("------------------------------------------\n");
		System.out.println("1: show Employee");
		System.out.println("2: search Employee by ID");
		System.out.println("3: Delete Employee by ID");
		System.out.println("4: Exit Application");
		System.out.println("------------------------------------------\n");
		System.out.println("Enter Your Choice:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {// show Employees
			showEmployee(mo);
			System.out.println("------------------------------------------\n");

		}
			break;

		case 2: {// search by id
			System.out.println("Enter the ID:");
			int sid = sc.nextInt();
			System.out.println("------------------------------------------\n");
			searchEmployee(mo, sid);
			System.out.println("------------------------------------------\n");
		}
			break;
		case 3: {// Delete Employee by ID
			System.out.println("Enter the ID:");
			int did = sc.nextInt();
			deleteEmployee(mo, did);
			System.out.println("------------------------------------------\n");
			showEmployee(mo);
			System.out.println("------------------------------------------\n");
		}
			break;
		case 4: {
			System.out.println("Exititng Application please wait");
			System.exit(0);
			}
			break;
		default: {
			System.out.println("Enter Valid choice.");
		}
		}
		}while(true);
	}

	// ******Methods*****
	// Show EMployees
	public static void showEmployee(Map<String, Map> mout) {
		// retrieving outer Department keys
		Set<String> outKeySet = mout.keySet();
		// we received Department
		Iterator<String> o = outKeySet.iterator();
		while (o.hasNext()) {
			Object oky = o.next();
			System.out.println(oky);
			// inner key of integer
			Map<Integer, Employee> in = mout.get(oky);

			Set<Integer> inKeySet = in.keySet();

			// get Integer as keys
			Iterator<Integer> i = inKeySet.iterator();

			while (i.hasNext()) {
				Object key = i.next();
				Object value = (Employee) in.get(key);
				System.out.println(value);
			}
		}
	}// EOF FIRST METHOD

	// search EMployee by ID
	public static void searchEmployee(Map<String, Map> mout, int sid) {
		// retrieving outer Department keys
		Set<String> outKeySet = mout.keySet();
		// we received Department
		Iterator<String> o = outKeySet.iterator();
		while (o.hasNext()) {
			Object oky = o.next();
			// inner key of integer
			Map<Integer, Employee> in = mout.get(oky);

			Set<Integer> inKeySet = in.keySet();

			// get Integer as keys
			Iterator<Integer> i = inKeySet.iterator();

			while (i.hasNext()) {
				Object key = i.next();
				Employee value = (Employee) in.get(key);
				if (sid == value.getId()) {
					System.out.println(oky);
					System.out.println(value);
				}
			}
		}
	}//EOF Second Method
	
	//delete Employee by ID
	public static void deleteEmployee(Map<String, Map> mo,int did)
	{
		// get outer Department keys
		Set<String> outKeySet = mo.keySet();
		
		Iterator<String> out = outKeySet.iterator();
		while(out.hasNext())
		{
			// get inner keys
			Object okey = out.next();
			Map<Integer, Employee> min= mo.get(okey);
			
			Set<Integer> ikey = min.keySet();
			
			Iterator<Integer> inkey = ikey.iterator();
			while(inkey.hasNext())
			{
				Object key = inkey.next();
				Employee val = (Employee) min.get(key);
				if(did == val.getId())
				{
					min.remove(key);
				}
			}
		}
	}//EOD Delete MEthod
}
