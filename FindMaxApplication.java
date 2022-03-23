import java.util.*;

public class FindMaxApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		do {// operations to be perform
			System.out.println("\n\nPlease Select Choice\n");
			System.out.println("1: Add Elements to the ArrayList");
			System.out.println("2: Show Elemnts of ArrayList ");
			System.out.println("3: Finding Maximum Element from the ArrayList");
			System.out.println("4:Finding Minimum Elemnt of the ArrayList");
			System.out.println("5: Sort Elements in Ascending Orrder");
			System.out.println("6:Sort Elements in Descending Order");
			System.out.println("7: Search Element is present in the List or Not");
			System.out.println("8: Exit the Operation");

			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the Total Values you want to add");
				int count = sc.nextInt();
				System.out.println("Enter the Values in List");
				addValue(al, count); // entering value method call
			}
				break;

			case 2: {
				System.out.println("Show the Values in ArrayList");
				showValue(al); // show value method call
			}
				break;
			case 3: {
				System.out.println("Show the MAximum Value in ArrayList");
				maxValue(al);
			}
				break;
			case 4: {
				System.out.println("Show the Minimum Values in ArrayList");
				minValue(al);
			}
				break;
			case 5: {
				sortAscending(al);
				System.out.println("After Sorting List in DESCENDING ORDER");
				{
					for (Integer i : al) {
						System.out.println(i);
					}
				}
			}
				break;
			case 6: {
				sortDescending(al);
				System.out.println("After Sorting List in DESCENDING ORDER");
				{
					for (Integer i : al) {
						System.out.println(i);
					}
				}
			}
				break;
			case 7: {
				System.out.println("Enter the Value to be searched");
				int value = sc.nextInt();
				searchElement(al, value);
			}
				break;
			case 8: {
				System.out.println("Exiting Apllication");
				System.exit(0);
			}
			default: {
				System.out.println("Please Enter Valid Choice");
			}
			}
		} while (true);
	}

	// adding value to the ArrayList
	public static void addValue(ArrayList<Integer> al, int count) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < count; i++) {
			int value = sc.nextInt();
			al.add(value);
		}
	}

	// Display the Values form List
	public static void showValue(ArrayList<Integer> al) {
		for (Integer i : al) {
			System.out.println(i);
		}
	}

	// Find Max Value from the List
	public static void maxValue(ArrayList<Integer> al) throws NoSuchElementException, ClassCastException {
		System.out.println(Collections.max(al));
	}

	// Find Minimum Value from ArrayList
	public static void minValue(ArrayList<Integer> al) throws NoSuchElementException, ClassCastException {
		System.out.println(Collections.min(al));
	}

	// Sort the List Ascending
	public static void sortAscending(ArrayList<Integer> al)
			throws UnsupportedOperationException, ClassCastException, IllegalArgumentException {
		Collections.sort(al);
	}

	// Sort List Descending Order
	public static void sortDescending(ArrayList<Integer> al)
			throws UnsupportedOperationException, ClassCastException, IllegalArgumentException {
		Collections.sort(al, new myComparator());
	}

	// Search the Element
	public static void searchElement(ArrayList<Integer> al, int value) throws ClassCastException {
		sortAscending(al);
		System.out.println(Collections.binarySearch(al, value));
	}
}

class myComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		return i2.compareTo(i1);
	}

}