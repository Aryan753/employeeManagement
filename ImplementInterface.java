package org.employee;

import java.sql.*;

public class ImplementInterface implements EmployeeInterface {
    Connection con;
    @Override
    public void createEmployee(Employee emp) {
      con =DBconnection.createdbconnection();
      String query="insert into employee value(?,?,?,?)";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt=pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee Inserted Successfully");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con=DBconnection.createdbconnection();
        String query="select * from employee";
        System.out.println("Enter employee detail : ");
        System.out.format("%s\t%s\t%s\t\t%s\n","ID","NAME","SALARY","AGE");
        System.out.println("----------------------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("----------------------------------------------------------");
            }
        }catch (Exception e){

        }
    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        con=DBconnection.createdbconnection();
        String query="select * from employee where id="+id;
        System.out.format("%s\t%s\t%s\t\t%s\n","ID","NAME","SALARY","AGE");
        System.out.println("----------------------------------------------------------");
        try{
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("----------------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBconnection.createdbconnection();
        String query="update employee set name =? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("Employee updated Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
       con=DBconnection.createdbconnection();
       String query="delete from employee where id=?";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setInt(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0){
               System.out.println("Employee delete Successfully"+id);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
