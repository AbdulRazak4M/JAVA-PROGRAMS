import java.util.*;

class Employee {
    private int id;
    private float salary;
    private String name;

    Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

}

public class EmployeeApplicationVector {
    public static void main(String[] args) {
        // create vector Application
        Vector<Employee> v = new Vector<Employee>();
        Scanner sc = new Scanner(System.in);
        do {
            // Operations List
            System.out.println("1: Add Employee In List.");
            System.out.println("2: View All Employees from List.");
            System.out.println("3: Search Employee by ID.");
            System.out.println("4: Delete Employee by ID from List.");
            System.out.println("5: Exit.");
            System.out.println("\n--------------------------------------------------------------\n");
            // user choice to perform operation
            System.out.println("Enter your Choice Opearation");
            int choice = sc.nextInt();
            // perform opearation
            switch (choice) {
                // add Employee
                case 1: {
                    addEmployee(v);
                }
                    break;
                // View All EMployees
                case 2: {
                    displayDetails(v);
                }
                    break;
                // SearchEmployee by Id
                case 3: {
                    System.out.println("Enter the ID of EMployee You want to Search:");
                    int id = sc.nextInt();
                    searchEmployee(v, id);
                }
                    break;
                // Delete Employee by ID
                case 4: {
                    System.out.println("Enter the ID of Employee You want to Delete:");
                    int id = sc.nextInt();
                    Iterator<Employee> i = v.iterator();
                    while (i.hasNext()) {
                        try {
                            Employee e = i.next();
                            if (e.getId() == id) {
                                i.remove();
                                System.out.println("Employee Removed Successfully");
                            }
                        } catch (NoSuchElementException e) {
                            System.out.println("Element Not found Exception");
                        }
                    }

                }
                    break;
                // exit
                case 5: {
                    System.exit(0);
                }
                    break;
                default: {
                    System.out.println("Please Enter Vlaid Choice.");
                }
            }
        } while (true);
    }

    // add employee Method 1
    public static void addEmployee(Vector<Employee> v) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Employees You Want to Add: ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int id;
            float salary;
            String name;
            System.out.println("Employee Id: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Employee Name:");
            name = sc.nextLine();
            System.out.println("Employee Salary: ");
            salary = sc.nextFloat();
            Employee e = new Employee(id, name, salary);
            v.add(e);
        }
    }

    // Diplay Employee Deatail
    public static void displayDetails(Vector<Employee> v) {
        try {
            for (Object o : v) {
                Employee e = (Employee) o;
                System.out.println("----------------------------------------------------------");
                System.out.println("ID: " + e.getId() + "\tNAME: " + e.getName() + "\tSALARY: " + e.getSalary());
                System.out.println("----------------------------------------------------------");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    // Search Employee
    public static void searchEmployee(Vector<Employee> v, int id) {
        boolean search = false;
        for (Employee e : v) {
            if (e.getId() == id) {
                System.out.println("Employee Found: ");
                System.out.println("----------------------------------------------------------");
                System.out.println("ID: " + e.getId() + "\tNAME: " + e.getName() + "\tSALARY: " + e.getSalary());
                System.out.println("----------------------------------------------------------");
                break;
            }
        }
    }
}