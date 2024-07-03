/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g3.studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Harvey
 */
public class JavaMySQL {
    
    public static void main (String[]args){
    
        try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementDB", "root", "root");//Establishing connection
                    System.out.println("Connected With the database successfully"); //Message after successful connection
 
            } catch (SQLException e) {
 
                    System.out.println("Error while connecting to the database"); //Message if something goes wrong while conneting to the database
 
                            }
        
    }
    
}
