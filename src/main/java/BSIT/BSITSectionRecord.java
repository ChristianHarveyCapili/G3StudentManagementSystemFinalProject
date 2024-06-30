/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BSIT;

import g3.studentmanagementsystem.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BSITSectionRecord implements ActionListener {
     
   JFrame frame = new JFrame();
   JLabel welcomeLabel = new JLabel("WELCOME TO");
   JLabel welcomesLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
   JLabel selectLabel = new JLabel ("Select an option:");
   JButton studentButton = new JButton("STUDENT RECORD");
   JButton gradeButton = new JButton("GRADE");
   JButton attendanceButton = new JButton("ATTENDANCE");
   JButton returnStudentSection= new JButton("Return");
   private Color blue= new Color(0,74,173);
   private Color yellow = new Color(255,222,89);
   private ImageIcon schoollogo = new ImageIcon("tnismall.png");
   private JLabel logo = new JLabel(schoollogo);
   
    public void BSITSectionRecord(){
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(blue);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        logo.setBounds(70, 150, schoollogo.getIconWidth(), schoollogo.getIconHeight());
        frame.add(logo);
              
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(frame.getWidth()/2,0, frame.getWidth()/2,frame.getHeight());
        panel.setVisible(true);
        panel.setBackground(yellow);
        frame.getContentPane().add(panel);
        
        welcomeLabel.setBounds(100,25,panel.getWidth()-20,35);
        welcomeLabel.setFont(new Font("Georgia", Font.BOLD, 25));
        welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomeLabel);
        
        welcomesLabel.setBounds(10,50, panel.getWidth()-20,35);
        welcomesLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        welcomesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomesLabel);
        
        selectLabel.setBounds(15,100, panel.getWidth()-20,35);
        selectLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        selectLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(selectLabel);
        
        //Buttons
        studentButton.setBounds(50, 200,panel.getWidth()-100, 50);
        studentButton.setFont(new Font("Verdana", Font.BOLD, 15));
        studentButton.setFocusable(false);
        studentButton.addActionListener(this);
        panel.add(studentButton);
        
        gradeButton.setBounds(50, 270, panel.getWidth()-100 , 50);
        gradeButton.setFont(new Font("Verdana", Font.BOLD, 15));
        gradeButton.setFocusable(false);
        gradeButton.addActionListener(this);
        panel.add(gradeButton);
        
        attendanceButton.setBounds(50, 340,panel.getWidth()-100 , 50);
        attendanceButton.setFont(new Font("Verdana", Font.BOLD, 15));
        attendanceButton.setFocusable(false);
        attendanceButton.addActionListener(this);
        panel.add(attendanceButton);
     
        returnStudentSection.setBounds(50, 410,panel.getWidth()-100 , 50);
        returnStudentSection.setFont(new Font("Verdana", Font.BOLD, 15));
        returnStudentSection.setFocusable(false);
        returnStudentSection.addActionListener(this);
        panel.add(returnStudentSection);
             
                       
                  
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == studentButton){
            frame.dispose();
            BSITStudentRecord record = new BSITStudentRecord();
                }
        
        else if(e.getSource() == gradeButton){
            frame.dispose();
            BSITStudentGrade grade = new BSITStudentGrade();
                }
        
        else if(e.getSource() == attendanceButton){
            frame.dispose();
            BSITStudentAttendance attendance = new BSITStudentAttendance();
                }
        else if(e.getSource() == returnStudentSection){
        frame.dispose();
        StudentSection ss = new StudentSection();
        }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }
}
