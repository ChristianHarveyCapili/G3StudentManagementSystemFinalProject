/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TalisaySection;

import g3.studentmanagementsystem.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingConstants;

/**
 *
 * @author DEAN MARC PECHAYCO
 */
public class TalisaySectionRecord implements ActionListener {
   JFrame frame = new JFrame();
   JLabel welcomeLabel = new JLabel("WELCOME TO");
   JLabel welcomesLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
   JLabel selectLabel = new JLabel ("Select an option:");
   JButton studentButton = new JButton("STUDENT RECORD");
   JButton gradeButton = new JButton("GRADE");
   JButton attendanceButton = new JButton("ATTENDANCE");
   JButton returnStudentSection = new JButton("Return");
   
    public void TalisaySectionRecord(){
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.blue);
        frame.setResizable(false);
        
        
              
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(frame.getWidth()/2,0, frame.getWidth()/2,frame.getHeight());
        panel.setVisible(true);
        panel.setBackground(Color.yellow);
        frame.getContentPane().add(panel);
        
        welcomeLabel.setBounds(100,25,panel.getWidth()-20,35);
        welcomeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomeLabel);
        
        welcomesLabel.setBounds(50,50, panel.getWidth()-20,35);
        welcomesLabel.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        welcomesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomesLabel);
        
        selectLabel.setBounds(15,100, panel.getWidth()-20,35);
        selectLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selectLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(selectLabel);
        
        //Buttons
        studentButton.setBounds(50, 200,panel.getWidth()-100, 50);
        studentButton.setFocusable(false);
        studentButton.addActionListener(this);
        panel.add(studentButton);
        
        gradeButton.setBounds(50, 270, panel.getWidth()-100 , 50);
        gradeButton.setFocusable(false);
        gradeButton.addActionListener(this);
        panel.add(gradeButton);
        
        attendanceButton.setBounds(50, 340,panel.getWidth()-100 , 50);
        attendanceButton.setFocusable(false);
        attendanceButton.addActionListener(this);
        panel.add(attendanceButton);
        
        returnStudentSection.setBounds(50 ,410, panel.getWidth()-100, 50);
        returnStudentSection.setFocusable(true);
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
            TalisayStudentRecord record = new TalisayStudentRecord();
                }
        
        else if(e.getSource() == gradeButton){
            frame.dispose();
            TalisayStudentGrade grade = new TalisayStudentGrade();
                }
        
        else if(e.getSource() == attendanceButton){
            frame.dispose();
            TalisayStudentAttendance attendance = new TalisayStudentAttendance();
                }
        else if(e.getSource()  ==returnStudentSection){
            frame.dispose();
            StudentSection ss = new StudentSection();
                }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }

}
