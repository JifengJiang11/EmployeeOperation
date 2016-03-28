This assignment is very simple,and record is about employee information. It contains id, first name, last name and department. id is primary key, can't be modified.

Project directory:
----WebContent: including webpage(jsp file) and lib file.
----src:
--------config: config file used for directly SQL access.
--------controller: servlet file which communicate with webpage, handle web request.
--------dao: encapsulate all the operations of database, 
	   including hibernate and directly SQL
--------entities: schema for data.
--------model: container for data.
