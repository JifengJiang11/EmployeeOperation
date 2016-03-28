package com.DAO;
import com.entities.Employee;
import java.util.List;

/**
 * @date 2016/03/25
 * @author Miao Shan
 *
 */
public interface EmployeeDao {
	
	/**
	 * Get one employee by id
	 * @param id
	 * @return
	 */
	public Employee getEmployee(int id);
	
	/**
	 * Get all the employee in the database
	 * @return
	 */
	public List<Employee> employeeList();
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
