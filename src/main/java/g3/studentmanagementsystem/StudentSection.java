/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g3.studentmanagementsystem;

import NarraSection.*;
import MahoganySection.*;
import BagrasSection.*;
import TalisaySection.*;
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
   JButton btnMahogany = new JButton("Section Mahogany");
   JButton btnNarra = new JButton("Section Narra");
   JButton btnBagras = new JButton("Section Bagras");
   JButton btnTalisay = new JButton("Section Talisay");
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
        btnMahogany.setBounds(50, 200,panel.getWidth()-100, 50);
        btnMahogany.setFont(new Font("Verdana", Font.BOLD, 15));
        btnMahogany.setFocusable(false);
        btnMahogany.addActionListener(this);
        panel.add(btnMahogany);
        
        btnNarra.setBounds(50, 270, panel.getWidth()-100 , 50);
        btnNarra.setFont(new Font("Verdana", Font.BOLD, 15));
        btnNarra.setFocusable(false);
        btnNarra.addActionListener(this);
        panel.add(btnNarra);
        
        btnBagras.setBounds(50, 340,panel.getWidth()-100 , 50);
        btnBagras.setFont(new Font("Verdana", Font.BOLD, 15));
        btnBagras.setFocusable(false);
        btnBagras.addActionListener(this);
        panel.add(btnBagras);
     
        btnTalisay.setBounds(50, 410,panel.getWidth()-100 , 50);
        btnTalisay.setFont(new Font("Verdana", Font.BOLD, 15));
        btnTalisay.setFocusable(false);
        btnTalisay.addActionListener(this);
        panel.add(btnTalisay);     
        
        ImageIcon image = new ImageIcon ();
        
        logo.setBounds(70, 150, schoollogo.getIconWidth(), schoollogo.getIconHeight());
        frame.add(logo);

        
                  
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnMahogany){
            frame.dispose();
            MahoganySectionRecord ms = new MahoganySectionRecord();
            ms.MahoganySectionRecord();
            }
        
        else if(e.getSource() == btnNarra){
            frame.dispose();
            NarraSectionRecord ns = new NarraSectionRecord();
            ns.NarraSectionRecord();
                }
        
        else if(e.getSource() == btnBagras){
             frame.dispose();
             BagrasSectionRecord bs = new BagrasSectionRecord();
             bs.BagrasSectionRecord();
               }
        else if(e.getSource() == btnTalisay){
            frame.dispose();
            TalisaySectionRecord ts = new TalisaySectionRecord();
            ts.TalisaySectionRecord();
                }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
