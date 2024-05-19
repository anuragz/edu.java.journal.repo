package edu.java.journal.basic.collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

	private static final Date DOJ = new Date();

	public static void main(String[] args) {
		Map<HashMapKey, Employee> emps = createEmployees();
		System.out.println(emps);
		
		//Add multiple values with same has
		Integer x = 10;
		System.out.println("Hashcode of int is its value!");
		System.out.println("Hashcode of "+x+" is "+x.hashCode());
				
		//Print content of hash map using for each loop
		System.out.println("Print content of hash map using for each loop");
		for(Map.Entry<HashMapKey, Employee> entry: emps.entrySet()) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
			
		}
		//Print content of hash map using iterator
		System.out.println("Print content of hash map using iterator and entryset");
		Iterator<Entry<HashMapKey,Employee>> iterator = emps.entrySet().iterator();
        while (iterator.hasNext()) {
        	Entry<HashMapKey, Employee> entry = iterator.next();
        	System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        //Print content of hash map using iterator
      	System.out.println("Print content of hash map using iterator and keyset");
        Iterator<HashMapKey> iterator2  = emps.keySet().iterator();
        while (iterator2.hasNext()) {
        	HashMapKey key = iterator2.next();
            System.out.println(key+" - "+emps.get(key));
        }
        
        //Print content of hash map using lambda expression
        System.out.println("Print content of hash map using lambda expression");
        emps.forEach((key, value) -> {System.out.println(key+" - "+value);});
        
        //Print content of hash map using stream API
        System.out.println("Print content of hash map using stream API");
        emps.entrySet().stream().forEach((entry) -> {System.out.println(entry.getKey()+" - "+entry.getValue());});
		
        //Search map
        System.out.println("Search content of hash map");
        System.out.println("Map contains key - "+emps.containsKey(new HashMapKey(1, "B")));
        //To do : why it returns false - due to difference in timestamp
        System.out.println("Map contains value - "+emps.containsValue(new Employee(1, "B", DOJ, 100d)));
        
	}
	
	static Map<HashMapKey,Employee> createEmployees() {
		Map<HashMapKey, Employee> employees = new HashMap<>();
		HashMapKey key0 = new HashMapKey(0, "A");
		Employee emp1 = new Employee(0, "A", DOJ, 100d);
		employees.put(key0,emp1);
		// Add anonymous employees
		employees.put(new HashMapKey(1, "B"), new Employee(1, "B", DOJ, 100d));
		employees.put(new HashMapKey(2, "C"), new Employee(2, "C", DOJ, 100d));
		employees.put(new HashMapKey(3, "D"), new Employee(3, "D", DOJ, 100d));
		employees.put(new HashMapKey(4, "E"), new Employee(4, "E", DOJ, 100d));
		employees.put(new HashMapKey(5, "F"), new Employee(5, "F", DOJ, 100d));
		return employees;
	}
	

}
