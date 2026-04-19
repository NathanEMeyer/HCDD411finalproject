package psu.edu.FinalProject.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code LOL!
	
	// ass a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}