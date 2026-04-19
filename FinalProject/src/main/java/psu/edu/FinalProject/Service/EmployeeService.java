package psu.edu.FinalProject.Service;

import java.util.List;

import psu.edu.FinalProject.Entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

}
