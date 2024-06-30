package MahoganySection;

import g3.studentmanagementsystem.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DEAN MARC PECHAYCO
 */
public  class MahoganySectionRecord implements ActionListener {
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
   
   
   public void MahoganySectionRecord(){
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(blue);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
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
             
        ImageIcon image = new ImageIcon ("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\Project\\src\\main\\java\\Images\\Logo.png");
        
        Image images = image.getImage();
        Image pic =images.getScaledInstance(frame.getWidth()/2, frame.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(pic);
        
        JLabel imageLabel = new JLabel (image);
        imageLabel.setIcon(image);
        imageLabel.setBounds(0, 0, frame.getWidth()/2, frame.getHeight());
        frame.getContentPane().add(imageLabel);

        
                  
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == studentButton){
            frame.dispose();
            MahoganyStudentRecord record = new MahoganyStudentRecord();
                }
        
        else if(e.getSource() == gradeButton){
            frame.dispose();
            MahoganyStudentGrade grade = new MahoganyStudentGrade();
                }
        
        else if(e.getSource() == attendanceButton){
            frame.dispose();
            MahoganyStudentAttendance attendance = new MahoganyStudentAttendance();
                }
        else if(e.getSource() == returnStudentSection){
            frame.dispose();
            StudentSection studentsection = new StudentSection();
            
            
        }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }
}