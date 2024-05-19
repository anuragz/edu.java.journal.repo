package edu.java.journal.basic.collections;
import java.util.*;

public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		//if o1 > o2 return + integer
		//if o1 == o2 return 0
		//if o1 < o2 return - integer
		//here string compareTo is used
		return (o1.getName()).compareTo(o2.getName());
	}
}
