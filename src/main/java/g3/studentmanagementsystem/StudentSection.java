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
   
   
    public StudentSection(){
       
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
        btnMahogany.setBounds(50, 200,panel.getWidth()-100, 50);
        btnMahogany.setFocusable(false);
        btnMahogany.addActionListener(this);
        panel.add(btnMahogany);
        
        btnNarra.setBounds(50, 270, panel.getWidth()-100 , 50);
        btnNarra.setFocusable(false);
        btnNarra.addActionListener(this);
        panel.add(btnNarra);
        
        btnBagras.setBounds(50, 340,panel.getWidth()-100 , 50);
        btnBagras.setFocusable(false);
        btnBagras.addActionListener(this);
        panel.add(btnBagras);
     
        btnTalisay.setBounds(50, 410,panel.getWidth()-100 , 50);
        btnTalisay.setFocusable(false);
        btnTalisay.addActionListener(this);
        panel.add(btnTalisay);     
        
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
