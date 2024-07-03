/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DICT;


import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


/**
 *
 * @author CHRISTIAN HARVEY CAPILI, DEAN MARC PECHAYCO, ALDRIN KYLE ALMENANZA
 */
public class DICTStudentAttendance extends JFrame implements ActionListener {
    
    JFrame DICTFrame;
    JPanel headerPanel;
    JLabel headerLabel,subheaderLabel;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton addButton,returnButton,delButton;
    ImageIcon schoollogoyellow;
    
    
    public DICTStudentAttendance() {
        
        DICTFrame = new JFrame();
        DICTFrame.setTitle("Student Attendance");
        DICTFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DICTFrame.setPreferredSize(new Dimension(1000, 800));
        DICTFrame.getContentPane().setBackground(new Color(0, 74, 173));
        DICTFrame.setLayout(null);
        DICTFrame.pack();
        DICTFrame.setLocationRelativeTo(null);
        DICTFrame.setResizable(false);
        DICTFrame.setVisible(true);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));   
        headerPanel.setBounds(0, 0, 1000, 125);
        headerPanel.setLayout(new BorderLayout());
        
        schoollogoyellow = new ImageIcon("tniyellowsmall.png");
        Image resizedlogoyellow = schoollogoyellow.getImage().getScaledInstance(130,130, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(160,0,130,125);
        headerPanel.add(logoyellow);
         
        headerLabel = new JLabel("STUDENT ATTENDANCE RECORD");        
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(headerLabel);
        
        subheaderLabel = new JLabel("Course - DICT", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 60, 1000, 50);
        subheaderLabel.setForeground(Color.WHITE);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        subheaderLabel.setForeground(black);
        DICTFrame.add(subheaderLabel);
        
        
        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "Monday","Tuesday","Wednesday","Thursday","Friday"}, 50);
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
         
       
      TableColumnModel columnModel = table.getColumnModel(); 
           String[] choices = { "Present", "Absent", "Excuse" };
            JComboBox<String> attendanceComboBox = new JComboBox<>(choices);

           for (int i = 4; i <= 8; i++) {
           try {
              TableColumn column = columnModel.getColumn(i);
               column.setCellEditor(new DefaultCellEditor(attendanceComboBox));
                 } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error: Column index " + i + " is out of bounds. Skipping.");
                     }
                        }
       
       
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
        
        DICTFrame.add(scrollPane);
        DICTFrame.add(headerPanel);
        DICTFrame.add(addButton);
        DICTFrame.add(delButton);
        DICTFrame.add(returnButton);

        DICTFrame.pack();
        DICTFrame.setVisible(true);
        
        
       
            }
     private void addRow() {

        model.addRow(new Object[]{"","","","","Select Status","Select Status","Select Status","Select Status", "Select Status"});

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
            DICTFrame.dispose();
           DICTSectionRecord dict = new DICTSectionRecord();
           dict.DICTSectionRecord();
        }
    }
}