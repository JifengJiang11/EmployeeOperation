package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.PropertyManager;
import com.util.DirectlyDatabase;
import com.entities.Employee;

public class EmployeeDaoSQLImpl implements EmployeeDao {

	@Override
	public Employee getEmployee(int id) {
		Employee e = new Employee();
		try {
			List<Employee> list = DirectlyDatabase.query(PropertyManager.getProperty("db_employee_select"), id+""); 
			if(list.size() > 0) {
				e = list.get(0);
			}
		} catch (SQLException ex) {
            System.out.println(ex.toString());
        }			
		return e;
	}

	@Override
	public List<Employee> employeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = DirectlyDatabase.query(PropertyManager.getProperty("db_employee_selectAll"));
		} catch (SQLException ex) {
            System.out.println(ex.toString());
        }
		return employeeList;
	}

	@Override
	public void addEmployee(Employee employee) {
		try {
	        DirectlyDatabase.update(PropertyManager.getProperty("db_employee_insert"),employee.getFirstName()+"",
	        		employee.getLastName()+"",employee.getDepartment()+"");  
		} catch (SQLException ex) {
            System.out.println(ex.toString());
        }		
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
	        DirectlyDatabase.update(PropertyManager.getProperty("db_employee_update"), employee.getFirstName()+"",
	        		employee.getLastName()+"",employee.getDepartment()+"", employee.getId()+"");   
		} catch (SQLException ex) {
            System.out.println(ex.toString());
        }	
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
	        DirectlyDatabase.update(PropertyManager.getProperty("db_employee_delete"), id +"");   
		} catch (SQLException ex) {
            System.out.println(ex.toString());
        }	
	}
}
