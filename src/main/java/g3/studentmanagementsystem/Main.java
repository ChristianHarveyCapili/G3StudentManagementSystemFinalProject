/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package g3.studentmanagementsystem;

/**
 *
 * @author Harvey
 */
public class Main {
    public static void main (String[]args){
        
        UsernameAndPassword userPass = new UsernameAndPassword();      
        Login loginInfo = new Login(userPass.getLogin());
        StudentSection sc = new StudentSection();
        
    }
}
