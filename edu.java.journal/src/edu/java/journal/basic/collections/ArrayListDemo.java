package edu.java.journal.basic.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<Employee> emps = createEmployees();
		System.out.println("\nElements of Arraylist\n" + emps);

		// add element by index
		emps.add(0, new Employee(0, "A@1", new Date(), 100d));
		System.out.println("\nElement at index 0\n" + emps.get(0));
		
		// add element by index
		try {
		System.out.println("\nTry to add item to a higher index(10)");
		emps.add(10, new Employee(10, "A@1", new Date(), 100d));
		System.out.println("\nElement at index 10\n" + emps.get(10));
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Can not add item to a higher index than current size " + emps.size());
		}

		// change element by index 
		emps.set(0, new Employee(0, "A@2", new Date(), 100d));
		System.out.println("\nUpdated element at index 0\n" + emps.get(0));

		// search element
		Integer empId = 10;
		System.out.println("\nSearch employee whose id is " + empId);
		Integer index = Collections.binarySearch(emps, new Employee(empId, null, null, null));
		if (index < 0) {
			System.out.println("\nSearched element is not found");
		} else {
			System.out.println("\nSearched element found at index " + index);
			System.out.println("\nElement at " + index + " is \n" + emps.get(index));
		}
		
		//iterate ArrayList using for each
		System.out.println("\nPrint element using for each loop");
		for(Employee e: emps) {
			System.out.println(e.getId()+" - "+ e.getName()+" - "+ e.getSalary());
		}
		//modify ArrayList using iterator
		System.out.println("\nPrint element using iterator");
		ListIterator<Employee> liter = emps.listIterator(); 
		while(liter.hasNext()) {
			Employee current = liter.next();
			current.setSalary(200d);
			System.out.println(current.getId()+" - "+ current.getName());
		}
		//add element to ArrayList using iterator
		System.out.println("\nAdd element using iterator");
		liter.add(new Employee(7, "G", new Date(), 100d));
		liter.add(new Employee(8, "H", new Date(), 100d));
		
		try {
		//remove element to ArrayList using iterator		
		System.out.println("\nRemove last element using iterator");
		liter.remove();
		}catch(IllegalStateException e) {
			System.out.println("Removing the last element using iterator remove will cause exception if iterator has finished");
		}
		
		//iterate ArrayList using iterator
		System.out.println("\nPrint element using iterator");
		Iterator<Employee> iter = emps.iterator(); 
		while(iter.hasNext()) {
			Employee current = iter.next();
			System.out.println(current.getId()+" - "+ current.getName()+" - "+ current.getSalary());
		}
	}

	static List<Employee> createEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee(1, "A", new Date(), 100d);
		employees.add(emp1);
		// Add anonymous employees
		employees.add(new Employee(2, "B", new Date(), 100d));
		employees.add(new Employee(3, "C", new Date(), 100d));
		employees.add(new Employee(4, "D", new Date(), 100d));
		employees.add(new Employee(5, "E", new Date(), 100d));
		employees.add(new Employee(6, "F", new Date(), 100d));
		return employees;
	}

}
