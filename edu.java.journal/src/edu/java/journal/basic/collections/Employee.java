package edu.java.journal.basic.collections;

import java.util.Date;
import java.util.Objects;

public class Employee implements Comparable<Employee>{

	Integer id;
	String name;
	Date doj;
	Double salary;
	
	public Employee(Integer id, String name, Date doj, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.doj = doj;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doj, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(doj, other.doj) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", doj=" + doj + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {		
		return this.getId()<o.getId()? -1:(this.getId()>o.getId()? 1:0);
		
	}
	
}
