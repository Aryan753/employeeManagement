package org.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
   static Connection con;
    public static Connection createdbconnection(){

        try {
            //load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            String url="jdbc:mysql://localhost:3306/employeedb?useSSL=false";
            String username="root";
            String password="1234";
            con=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
