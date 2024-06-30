/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g3.studentmanagementsystem;

import DIT.*;
import IE.*;
import DICT.*;
import BSIT.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Harvey
 */
public class StudentSection implements ActionListener {
    
    
   JFrame frame = new JFrame();
   JLabel welcomeLabel = new JLabel("WELCOME TO");
   JLabel welcomesLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
   JLabel selectLabel = new JLabel ("Select Student Section:");
   JButton btnIE = new JButton("IE COURSE");
   JButton btnBSIT = new JButton("BSIT COURSE");
   JButton btnDICT = new JButton("DICT COURSE");
   JButton btnDIT = new JButton("DIT COURSE");
   private Color yellow = new Color(255,222,89);
   private Color blue = new Color(0,74,173);
   private ImageIcon schoollogo = new ImageIcon("tnismall.png");
   private JLabel logo = new JLabel(schoollogo);
   
    public StudentSection(){
       
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
        btnIE.setBounds(50, 270,panel.getWidth()-100, 50);
        btnIE.setFont(new Font("Verdana", Font.BOLD, 15));
        btnIE.setFocusable(false);
        btnIE.addActionListener(this);
        panel.add(btnIE);
        
        btnBSIT.setBounds(50, 200, panel.getWidth()-100 , 50);
        btnBSIT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnBSIT.setFocusable(false);
        btnBSIT.addActionListener(this);
        panel.add(btnBSIT);
        
        btnDICT.setBounds(50, 340,panel.getWidth()-100 , 50);
        btnDICT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnDICT.setFocusable(false);
        btnDICT.addActionListener(this);
        panel.add(btnDICT);
     
        btnDIT.setBounds(50, 410,panel.getWidth()-100 , 50);
        btnDIT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnDIT.setFocusable(false);
        btnDIT.addActionListener(this);
        panel.add(btnDIT);     
             
        logo.setBounds(70, 150, schoollogo.getIconWidth(), schoollogo.getIconHeight());
        frame.add(logo);

        
                  
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIE){
            frame.dispose();
            IESectionRecord IE = new IESectionRecord();
           IE.IESectionRecord();
            }
        
        else if(e.getSource() == btnBSIT){
            frame.dispose();
            BSITSectionRecord bs = new BSITSectionRecord();
            bs.BSITSectionRecord();
                }
        
        else if(e.getSource() == btnDICT){
             frame.dispose();
             DICTSectionRecord dict = new DICTSectionRecord();
            dict.DICTSectionRecord();
               }
        else if(e.getSource() == btnDIT){
            frame.dispose();
            DITSectionRecord ts = new DITSectionRecord();
            ts.DITSectionRecord();
                }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }
}
