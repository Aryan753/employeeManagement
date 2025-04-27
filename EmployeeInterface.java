package org.employee;

public interface EmployeeInterface {
    //create employee
    public void createEmployee(Employee emp);
    //show emolyee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnId(int id);
    // update the employee
    public void updateEmployee(int id,String name);
    //delete
    public void deleteEmployee(int id);
}
