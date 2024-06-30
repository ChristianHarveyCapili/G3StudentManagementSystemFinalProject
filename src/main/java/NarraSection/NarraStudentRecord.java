/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NarraSection;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *
 * @author DEAN MARC PECHAYCO
 */
public class NarraStudentRecord extends JFrame implements ActionListener {
    
    JFrame narraFrame;
    JPanel headerPanel;
    JLabel headerLabel, subheaderLabel;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton addButton,returnButton,delButton;
    
    
    public NarraStudentRecord() {
        
        narraFrame = new JFrame();
        narraFrame.setTitle("Student Attendance");
        narraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        narraFrame.setPreferredSize(new Dimension(1000, 800));
        narraFrame.getContentPane().setBackground(new Color(0, 74, 173));
        narraFrame.setLayout(null);
        narraFrame.pack();
        narraFrame.setLocationRelativeTo(null);
        narraFrame.setResizable(false);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));   
        headerPanel.setBounds(0, 0, 1000, 100);
        
        headerLabel = new JLabel("STUDENT ATTENDANCE RECORD");
        headerLabel.setPreferredSize(new Dimension(450, 100)); 
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setForeground(black);
        headerPanel.add(headerLabel);
        
        subheaderLabel = new JLabel("Section - Narra");
        subheaderLabel.setBounds(400, 50, 500, 50);
        subheaderLabel.setForeground(Color.WHITE);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        subheaderLabel.setForeground(black);
        narraFrame.add(subheaderLabel);
        
        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "Age","Birthday","Gender","Contact No."}, 0);
        table = new JTable(model);
        table.setOpaque(false);
        table.setBackground(new Color(245, 245, 220));
        
       tableHeader = table.getTableHeader();
       table.getTableHeader().setBackground(new Color(255, 222, 89));
       table.getTableHeader().setForeground(black);
       table.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 13));
       
       scrollPane = new JScrollPane(table);
       scrollPane.setBounds(35, 160, 900, 500);
       
       tableBorderColor = new Color(0, 0, 0);
       scrollPane.setBorder(new LineBorder(tableBorderColor, 8));
         
       
      String[] choices = { "Male", "Female"};
       JComboBox<String> gender = new JComboBox<String>(choices);
       table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(gender));

      
       
        addButton = new JButton("Add New Row");
        addButton.setFont(new Font("Serif", Font.BOLD, 16));
        addButton.setForeground(black);
        addButton.setBackground(new Color(255, 222, 89));
        addButton.setOpaque(true);
        addButton.setBorder(null);
        addButton.setBounds(50, 680, 200, 30);
        addButton.addActionListener(this);
        
        delButton = new JButton("Delete Row");
        delButton.setFont(new Font("Serif", Font.BOLD, 16));
        delButton.setForeground(black);
        delButton.setBackground(new Color(255, 222, 89));
        delButton.setOpaque(true);
        delButton.setBorder(null);
        delButton.setBounds(270, 680, 200, 30);
        delButton.addActionListener(this);
        
        
        returnButton = new JButton("Return");
        returnButton.setFont(new Font("Serif", Font.BOLD, 16));
        returnButton.setForeground(black);
        returnButton.setBackground(new Color (255, 222, 89));
        returnButton.setOpaque(true);
        returnButton.setBorder(null);
        returnButton.setBounds(700, 680, 200, 30);
        returnButton.addActionListener(this);
        
        narraFrame.add(scrollPane);
        narraFrame.add(headerPanel);
        narraFrame.add(addButton);
        narraFrame.add(delButton);
        narraFrame.add(returnButton);

        narraFrame.pack();
        narraFrame.setVisible(true);
        
        
       
            }
     private void addRow() {

        model.addRow(new Object[]{"","","","","","","Select Gender",""});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
                addRow();
        }             
        if (e.getSource() == delButton) {
                 int selectedRow = table.getSelectedRow();
           if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Error! Please select row to delete.", "!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
        if(e.getSource() == returnButton){
           narraFrame.dispose();
           NarraSectionRecord ns = new NarraSectionRecord();
           ns.NarraSectionRecord();
        }
    }
}
