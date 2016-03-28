package com.controller;

import java.io.*;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDaoHiberImpl;
import com.DAO.EmployeeDaoSQLImpl;
import com.entities.Employee;

/**
 * 2016/03/23
 * author: Miao shan
 * Servlet implementation class EmployeeController
 */

//@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EDIT_JSP = "/add.jsp";
	private static final String SHOWALL_JSP = "/showAll.jsp";
    private EmployeeDaoHiberImpl ehDao = new EmployeeDaoHiberImpl();
    private EmployeeDaoSQLImpl esDao = new EmployeeDaoSQLImpl();
    private String way = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";
		if(action.equals("delete")) {
			Integer id =Integer.valueOf(request.getParameter("id"));
			ehDao.deleteEmployee(id);
			request.setAttribute("employeeList", ehDao.employeeList());
			forward = SHOWALL_JSP;
		} else if(action.equals("showAll")) {
			forward = SHOWALL_JSP;
			request.setAttribute("employeeList", ehDao.employeeList());
		} else if(action.equals("add")) {
			forward = EDIT_JSP;			
		} else if(action.equals("update")) {
			forward = EDIT_JSP;
			Integer id = Integer.valueOf(request.getParameter("id"));
			Employee e = ehDao.getEmployee(id);
			request.setAttribute("employee", e);
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee e = new Employee();
		e.setFirstName(request.getParameter("firstName"));
		e.setLastName(request.getParameter("lastName"));
		e.setDepartment(request.getParameter("department"));
		String id = request.getParameter("id");
		if(id == null || id.isEmpty()) {
			ehDao.addEmployee(e);
		} else {
			e.setId(Integer.parseInt(request.getParameter("id")));			
			ehDao.updateEmployee(e);
		}
		
		request.setAttribute("employeeList", ehDao.employeeList());
		request.getRequestDispatcher(SHOWALL_JSP).forward(request,  response);
	}

}
