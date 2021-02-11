# EmployeeManagement-API

Employee Management api is a rest api which is used to do CRUD operations on Employee.This application developed using SpringBoot,Mysql.

Database Setup:

1. Import sql file, which contains employee table structure.
2. Add database properties in application.properties file.
3. Start Mysql server.
4. Run this Springboot application.

It has below operations :

1.AddEmployee:
    Request url (POST) :http://localhost:8080/employeeManagement/addemployee
    Input:
    {
    "empName":"Sunil",
    "empDesignation":"Tester",
    "empSalary": 55000
    }

2.GetAllEmployees:
    Request url(GET) :http://localhost:8080/employeeManagement/allemployee

3.GetEmployeeById:
    Request url(GET) :http://localhost:8080/employeeManagement/getemployee/{id}

4.UpdateEmployeeById:
    Request url(PUT) :http://localhost:8080/employeeManagement/updateemployee
    Input:
    {
    "empId" : 5,
    "empName":"praveen",
    "empDesignation":"QA",
    "empSalary":"55000"
    }

5.DeleteEmployeeById:
    Request url(DELETE) :http://localhost:8080/employeeManagement/deleteemployee/{id}
