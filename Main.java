package org.employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeInterface intr=new ImplementInterface();
        System.out.println("welcome to employee Management");
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("1.Add Employee\n"+
                    "2.Show All Employee\n"+
                    "3.Show Employee Based On Id\n"+
                    "4.Upadate the employee id\n"
                    +
                    "5.delete the Employee Id\n");
            System.out.println("Enter choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter id");
                     id=sc.nextInt();
                    System.out.println("Enter name");
                     name=sc.next();
                    System.out.println("Enter Salary");
                    double salary= sc.nextDouble();
                    System.out.println("Enetr age");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setAge(age);
                    emp.setName(name);
                    emp.setSalary(salary);
                    intr.createEmployee(emp);
                    break;
                case 2:
                    intr.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details");
                    int empid=sc.nextInt();
                    intr.showEmployeeBasedOnId(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the name");
                    int empid1= sc.nextInt();
                    System.out.println("enter new name whic you want to update");
                    name=sc.next();
                    intr.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Eneter the id to delete");
                    id= sc.nextInt();
                    intr.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank You for using application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;

            }

        }while(true);

    }
}