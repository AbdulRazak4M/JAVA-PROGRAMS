import java.util.*;

class Employee
{   private int id;
    private String name;
    private double salary;
    // getters and setters
    public void setId(int id)
    {   this.id = id;
    }
    public int getId()
    {   return id;
    }
    public void setName(String name)
    {   this.name = name;
    }
    public String getName()
    {   return name;
    }
    public void setSalary(double salary)
    {   this.salary = salary;
    }
    public double getSalary()
    {   return salary;
    }

    public String toString()
    {
        return "ID: "+id+"\tNAME: "+name+"\tSALARY: "+salary;
    }
}

public class EmployeeApplicationWithMap
{
    public static void main(String[] args)
    {
        // Create Map Interface
        LinkedHashMap m = new LinkedHashMap();
       ArrayList<Employee> al = new ArrayList<Employee>();
         // create Employees 1
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Ram");
        e1.setSalary(10000);
        // create employee 2
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Shyam");
        e2.setSalary(20000);
        //create employee 3
        Employee e3 = new Employee();
        e3.setId(3);
        e3.setName("Dinesh");
        e3.setSalary(40000);
        //adding employees to the ArrayList
        al.add(e1);
        al.add(e2);
        al.add(e3);

        // Putting Department and EMployees data in map
        m.put("CSE",al);
        m.put("MECH",al);
        showEmployee(m);
    }

    public static void showEmployee(Map m)
    {
        Set keys = m.keySet();
        Iterator i = keys.iterator();
        while(i.hasNext())
        {
            Object key = i.next();
            Object value = m.get(key);
            ArrayList a = (ArrayList)value;
            System.out.println(key);
            for(Object o : a)
            {
                System.out.println(o);
            }
        }
    }

}