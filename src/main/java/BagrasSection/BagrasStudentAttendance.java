/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BagrasSection;

import MahoganySection.MahoganySectionRecord;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DEAN MARC PECHAYCO
 */
public class BagrasStudentAttendance implements ActionListener {
    
//private JPanel header,footer; still working on this part
    private JFrame frame = new JFrame ("STUDENT ATTENDANCE");
    private JTable table;
    private DefaultTableModel model;
    private JButton addButton, deleteButton, returnButton;  
    
    public BagrasStudentAttendance() {
        
        String[] StudentInfo = { "Student No.","Last Name","First Name", "Middle Name","Monday","Tuesday","Wednesday","Thursday", "Friday", "Saturday", "Sunday" };

        model = new DefaultTableModel(StudentInfo, 0);        
        table = new JTable(model);        
                     
        //Buttons
        addButton = new JButton("Add Student Grade");
        addButton.addActionListener(this);
        addButton.setBackground(Color.LIGHT_GRAY);
        
        deleteButton = new JButton("Delete Student Grade");
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.LIGHT_GRAY);
        
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        returnButton.setBackground(Color.LIGHT_GRAY);
        
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton);
          
        //frame
        frame.add(scrollPane, java.awt.BorderLayout.CENTER);
        frame.add(buttonPanel, java.awt.BorderLayout.SOUTH);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setVisible(true);
        frame.setSize(800,600 );
        frame.setResizable(false);
     
 
    }

    @Override
    //Button Actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {

            model.addRow(new Object[model.getColumnCount()]);
        }else if (e.getSource() == returnButton) {
           frame.dispose();
           BagrasSectionRecord bs = new BagrasSectionRecord();
           bs.BagrasSectionRecord();
        
        }else if (e.getSource() == deleteButton) {

            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
        } else {
                JOptionPane.showMessageDialog(frame, "Select a row to delete!");
            }
        }
    }
}


