package bo;

import java.util.ArrayList;

import model.Employee;
import dao.EmployeeDAO;

public class EmployeeBO {
	public ArrayList<Employee> getAllEmployee() {
		return new EmployeeDAO().getAllEmployee();
	}

	public Employee getEmployeeById(String id) {
		return new EmployeeDAO().getEmployeeById(id);
	}

	public boolean createEmployee(Employee employee) {
		return new EmployeeDAO().createEmployee(employee);
	}
	
	public boolean editEmployee(Employee employee) {
		return new EmployeeDAO().editEmployee(employee);
	}
	
	public boolean deleteEmployee(String id) {
		return new EmployeeDAO().deleteEmployee(id);
	}
}
