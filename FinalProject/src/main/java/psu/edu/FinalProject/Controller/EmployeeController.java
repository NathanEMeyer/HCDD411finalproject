package psu.edu.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import psu.edu.FinalProject.Entity.Employee;
import psu.edu.FinalProject.Service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EmployeeController {
    
	private EmployeeService employeeService;
    
	public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
	 
	@GetMapping("/")
    public String redirectToList() {
        return "landing";
    }
    
	@GetMapping("/emplrec/list")
    public String listEmployees(Model theModel) {
        
		// get the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        
        // add to the spring model
        theModel.addAttribute("emplrec", theEmployees);
        return "jupiter-homepage";
    }
	
	@GetMapping("/emplrec/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("emplrec", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/emplrec/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		//set employee as a model attribute to pre-populate the form
		theModel.addAttribute("emplrec", theEmployee);
		
		//send over to our form
		
		return "employee-form";
	}
	
	@PostMapping("/emplrec/save")
	public String saveEmployee(@ModelAttribute("emplrec") Employee theEmployee) {
		
		//save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/emplrec/list";
	}
	
	@GetMapping("/emplrec/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        
		// delete the employee
        employeeService.deleteById(theId);
        
		// redirect to the root dashboard
        return "redirect:/emplrec/list";
    }
	
}