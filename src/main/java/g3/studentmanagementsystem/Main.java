/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package g3.studentmanagementsystem;
import java.awt.EventQueue;
/**
 *
 * @author Harvey
 */
public class Main {
    public static void main (String[]args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
              StartScreen ss = new StartScreen();
              ss.setVisible(true);
              
                
            }
            
        });
            
    }
}
