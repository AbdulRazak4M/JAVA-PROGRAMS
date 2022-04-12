// ArrayList of Player with field name of id, name,run, sal.
// 1) sort by id
// 2) Sort by run in desscending order

import java.util.*;

class Player 
{
	private int id, run;
	private String name;
	private double salary;
	// default dummy constructor
	Player(){}
	// initiallize the object
	Player(int id, String name, int run, double salary)
	{
		this.id = id;
		this.name = name;
		this.run = run;
		this.salary = salary;
	}
	// method to return id
	public int getId()
	{
		return id;
	}
	//method to return name
	public String getName()
	{
		return name;
	}
	// method to return run
	public int getRun()
	{
		return run;
	}
	// method t return salary
	public double getSalary()
	{
		return salary;
	}
}
public class PlayerApplication
{
	public static void main(String[] args) throws Exception
	{
		// ArrayList of Player with field name of id, name,run, sal.
		ArrayList <Player> al = new ArrayList<Player>();
		Scanner sc = new Scanner(System.in);
		
		do{
		System.out.println("Operation  to be Performed");
		System.out.println("\n---------------------------------------------------\n");
		System.out.println("1: Add Player.");
		System.out.println("2: Sort By ID.");
		System.out.println("3: Sort By Run in Descending Order.");
		System.out.println("4: Exit Application.");
		System.out.println("\n---------------------------------------------------\n");
		System.out.println("Enter Your Choice of Operation");
		int choice = sc.nextInt();
		switch(choice)
		{ 
		// Add Player Data.
		case 1:
		{
			System.out.println("How Many Players you want to add");
			int count = sc.nextInt();
			for(int  i = 0; i < count; i++)
			{
				System.out.println("Enter ID of Player:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name of Player:");
				String name = sc.nextLine();
				System.out.println("Enter Runs of Player:");
				int run = sc.nextInt();
				System.out.println("Enter Salary of Player:");
				double sal = sc.nextDouble();
				Player p = new Player(id, name, run, sal);
				al.add(p);
			}	
		}
		break;
		
		// Sort player by ID
		case 2:
		{
			Collections.sort(al,new MyCompareId());
			showPlayer(al);
		}
		break;
		
		// Descending sort by Run
		case 3:
		{
			Collections.sort(al, new MyCompareRun());
			showPlayer(al);
		}
		break;
		
		// Exiting Applicatrion
		case 4:
		{
			System.out.println("Exiting Application Please Wait.");
			try{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{}
			System.exit(0);
		}
		default:
		{
			System.out.println("Please Enter Valid Choice.");
		}
		}
		}while(true);
		
	}
	
	// show by Id
	public static void showPlayer(ArrayList<Player> al)
	{
		for(Player p: al)
		{
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("ID: "+p.getId()+"\tNAME: "+p.getName()+"\tRUN: "+p.getRun()+"\tSALARY: "+p.getSalary());
			System.out.println("-------------------------------------------------------------------------");
		}
	}
}

//to Sort Data by using id
class MyCompareId implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		// manual Sorting by id
		Player p1 = (Player)o1;
		Player p2 = (Player)o2;
		if(p1.getId() < p2.getId())
			return -1;
		else 
			return 1;
	}
}
class MyCompareRun implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		// descending Sort by Run
		Player p1 = (Player) o1;
		Player p2 = (Player) o2;
		if(p1.getRun() > p2.getRun())
			return -1;
		else
			return 1;
	}
	
}