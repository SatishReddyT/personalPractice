package com.bhavna.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStore {
	List<Employee> list = new ArrayList<>();
	Map<String, List<Employee>> m = new HashMap<>();

	public void listEmployee() {
		Employee e1 = new Employee("Trived", 65000, "Hyderabad");
		Employee e2 = new Employee("Satish", 75000, "Chennai");
		Employee e3 = new Employee("Naresh", 95000, "Hyderabad");
		Employee e4 = new Employee("Ache Rajinikanth", 110000, "Bangalore");
		Employee e5 = new Employee("Narasimha", 80000, "Hyderabad");
		Employee e6 = new Employee("Srikanth", 120000, "Hyderabad");
		Employee e7 = new Employee("SaiLeela", 80000, "Pune");
		Employee e8 = new Employee("Raghu", 75000, "Hyderabad");
		Employee e9 = new Employee("Mallikarjun", 80000, "Bangalore");
		Employee e10 = new Employee("Sravan", 75000, "Chennai");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
	}

	public void functions() {

		// --->Using Streams find employee count whose name starts with "s"
		long count = list.stream().filter((e) -> e.geteName().startsWith("S")).count();
		System.out.println("the count of Employees whose name starts with \"s\" is : " + count);

		// --->Using Parallel Stream Print all the Employees with location "Hyderabad"
		System.out.println();
		List<Employee> l1 = list.parallelStream().filter((e) -> e.getLoc() == "Hyderabad").collect(Collectors.toList());
		System.out.println("the Employees with location  \"Hyderabad\" are : ");
		l1.forEach((e) -> System.out.println(e));

		// -->.Get Location and employees in that location output : Map<String,
		// List<Employees>> ex : key : "Hyderbad" value : Employees who reside in
		// Hyderabad
        System.out.println();
        System.out.println("the Map values with location as key and List<Employee as value : ");
		m.put("Hyderabad", list.stream().filter((e) -> e.getLoc() == "Hyderabad").toList());
		m.put("Pune", list.stream().filter((e) -> e.getLoc() == "Pune").toList());
		m.put("Chennai", list.stream().filter((e) -> e.getLoc() == "Chennai").toList());
		m.put("Bangalore", list.stream().filter((e) -> e.getLoc() == "Bangalore").toList());
		 for (Map.Entry<String,List<Employee>> entry : m.entrySet())
	            System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
		
		// -->.Using Streams Check if any Employee's Salary is > 100000
		System.out.println();
		List<Employee> l2 = list.stream().filter((e) -> e.getSal() > 100000).toList();
		System.out.println("the Employees whose salary is >100000 : ");
		l2.forEach((e) -> System.out.println(e));

		// -->Using Lambds's Write a logic to sort EmployeeList based on Name & location
		System.out.println();
		System.out.println("after sorting EmployeeList based on Name : ");
		list.sort((Employee e1, Employee e2) -> e1.geteName().compareTo(e2.geteName()));
		list.forEach((e) -> System.out.println(e));
		System.out.println();
		System.out.println("after sorting EmployeeList based on loc : ");
		list.sort((Employee e1, Employee e2) -> e1.getLoc().compareTo(e2.getLoc()));
		list.forEach((e) -> System.out.println(e));

	}

}
