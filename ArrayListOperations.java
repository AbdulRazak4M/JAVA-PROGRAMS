package org.home;

import java.util.*;

class DescSort implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {

		Integer I1 = (Integer) o1;
		Integer I2 = (Integer) o2;
		/*
		 * if (I1 < I2) { return 1; } else if (I1 > I2) { return -1; }
		 */
		return I2.compareTo(I1);

	}
}

	public class ArrayListOperations {

		public static void main(String[] args) throws Exception {
			// create scanner reference to take input from user
			Scanner sc = new Scanner(System.in);
			// create ArrayList
			ArrayList<Integer> al = new ArrayList<Integer>();

			do {
				// List of Operations
				System.out.println("Select Operation");
				System.out.println("--------------------------------------------------------");
				System.out.println("1: Add Elements to the ArrayList.");
				System.out.println("2: View All Elements of ArrayList.");
				System.out.println("3: Search Element from ArrayList.");
				System.out.println("4: Remove Element from ArrarList.");
				System.out.println("5: Sort ArrayList in Ascending order.");
				System.out.println("6: Sort ArrayList Descending Order.");
				System.out.println("7: exit the Application.");

				int choice = sc.nextInt();

				switch (choice) {
				// add elements in arraylist
				case 1: {
					System.out.println("Select how many elements do you want to add inside ArrayList:");
					int count = sc.nextInt();
					System.out.println("Enter Elements in array :");
					for (int i = 0; i < count; i++) {
						int val = sc.nextInt();
						al.add(val);
					}
				}
					break;
				// View the Elements of arrayList
				case 2: {
					display(al);
				}
					break;
				// Search Element from array
				case 3: {
					search(al);
				}
					break;
				// remove element
				case 4: {
					boolean r = removeElement(al);
					if (r) {
						System.out.println("Removed Successfully");
					} else {
						System.out.println("Element Not Removed Please Check Input Element");
					}
				}
					break;
				// Sort ArrayList Ascending Order
				case 5: {
					Collections.sort(al);
					display(al);
				}
					break;
				// sort array in descending order
				case 6: {
					DescSort d = new DescSort();
					Collections.sort(al, d);
					display(al);
				}
					break;
				case 7: {
					System.out.println("----EXITING APPLICATION----");
					System.exit(0);
				}
					break;
				}

			} while (true);

		}

		// To show Elements
		public static void display(ArrayList<?> al) throws NullPointerException, ClassCastException {
			for (Object o : al) {
				System.out.println(o);
			}
		}

		// to Search Elements
		public static void search(ArrayList<Integer> al) throws Exception {
			Scanner sc = new Scanner(System.in);
			// take searching element from user
			System.out.println("Enter the value to be search:");
			Integer value = sc.nextInt();
			if (al.contains(value)) {
				System.out.println("Element found");
			} else {
				System.out.println("Element not available");
			}
			// Remove Element
		}

		public static boolean removeElement(ArrayList<Integer> al) throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Element to be remove:");
			Integer i = sc.nextInt();
			boolean r = al.remove(i);
			return r;
		}

	}
