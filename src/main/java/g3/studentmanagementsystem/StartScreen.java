/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g3.studentmanagementsystem;
import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author admin
 */
public class StartScreen extends JFrame implements ActionListener {
 private JPanel ldgpanel = new JPanel();
    private Color blue= new Color(0,74,173);
    private Color yellow = new Color(255,222,89);
    private JButton ldgbutton = new JButton("Press Here to Start");
    private ImageIcon schoollogo = new ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\G3StudentManagementSystemFinalProject\\tni.png");
    private JLabel logo = new JLabel(schoollogo);
    StartScreen(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(blue);
        setSize(750,750);
        setTitle("Starting");
        
        logo.setBounds(120, 50, schoollogo.getIconWidth(), schoollogo.getIconHeight());
        add(logo);
        
        add(ldgbutton);
        ldgbutton.setBackground(blue);
        ldgbutton.setForeground(yellow);
        ldgbutton.setBounds(260,475,200,150);
        ldgbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        UsernameAndPassword userPass = new UsernameAndPassword();      
        Login loginInfo = new Login(userPass.getLogin());
    }
    
}
