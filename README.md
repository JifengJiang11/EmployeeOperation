# EmployeeOperation

This is a simple project about employee information CRUD operation, you can switch database access manner easily: hibernate or directly SQL. 
The information contains id, first name, last name and department. id is primary key, and auto increment, can't be modified.

Project directory:
----WebContent: including webpage(jsp file) and lib file.
----src:
--------config: config file used for directly SQL access.
--------controller: servlet file which communicate with webpage, handle web request.
--------DAO: encapsulate all the operations of database, 
	   including hibernate and directly SQL
--------entities: schema for data.
--------util: utility files for database connection.

Framework: Servlet + hibernate + MySQL + JSP + Tomcat

Deploy Process:
1:  create database
        database name: employee
        table name: employee 

        SQL Script is following:

                CREATE DATABASE `employee` /*!40100 DEFAULT CHARACTER SET utf8 */;

                CREATE TABLE `employee` (
                  `ID` int(4) NOT NULL AUTO_INCREMENT,
                  `first_name` varchar(45) DEFAULT NULL,
                  `last_name` varchar(45) DEFAULT NULL,
                  `department` varchar(45) DEFAULT NULL,
                  PRIMARY KEY (`ID`)) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


2:  modify the configuration file

	src/hibernate.cfg.xml: change database username and password.
	src/com/config/default.properties: change db_username and db_password.

3: run in the eclipse.

