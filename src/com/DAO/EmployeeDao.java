package com.DAO;
import com.entities.Employee;
import java.util.List;

/**
 * @date 2016/03/25
 * @author Miao Shan
 *
 */
public interface EmployeeDao {
	
	public Employee getEmployee(int id);
	
	public List<Employee> employeeList();
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
