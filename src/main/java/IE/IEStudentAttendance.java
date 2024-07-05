package IE;


import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


public class IEStudentAttendance extends JFrame implements ActionListener {
    
    JFrame IEFrame;
    JPanel headerPanel;
    JLabel headerLabel,subheaderLabel;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton addButton,returnButton,delButton;
    ImageIcon schoollogoyellow;
    
    
    public IEStudentAttendance() {
        
        IEFrame = new JFrame();
        IEFrame.setTitle("Student Attendance");
        IEFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IEFrame.setPreferredSize(new Dimension(1000, 800));
        IEFrame.getContentPane().setBackground(new Color(0, 74, 173));
        IEFrame.setLayout(null);
        IEFrame.pack();
        IEFrame.setLocationRelativeTo(null);
        IEFrame.setResizable(false);
        IEFrame.setVisible(true);
        
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
        
        subheaderLabel = new JLabel("Course - IE", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 60, 1000, 50);
        subheaderLabel.setForeground(Color.WHITE);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        subheaderLabel.setForeground(black);
        IEFrame.add(subheaderLabel);
        
        
        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "Monday","Tuesday","Wednesday","Thursday","Friday"}, 0);
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
        
        IEFrame.add(scrollPane);
        IEFrame.add(headerPanel);
        IEFrame.add(addButton);
        IEFrame.add(delButton);
        IEFrame.add(returnButton);

        IEFrame.pack();
        IEFrame.setVisible(true);
        
        
       
            }
     private void addRow() {

        model.addRow(new Object[]{"","","","","Select Status","Select Status","Select Status","Select Status", "Select Status"});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
                addRow();
                
                try {
                
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementdb","root","root");
                    
                    Statement st;
                    st = conn.createStatement();
                    
                    for(int i=0; i<model.getRowCount(); i++){
                        
                             
                        String Studno  = model.getValueAt(i, 1).toString();
                        String LastName  = model.getValueAt(i, 1).toString();
                        String FirstName  = model.getValueAt(i, 1).toString();
                        String MiddleName  = model.getValueAt(i, 1).toString();
                        String Monday  = model.getValueAt(i, 1).toString();
                        String Tuesday  = model.getValueAt(i, 1).toString();
                        String Wednesday  = model.getValueAt(i, 1).toString();
                        String Thursday  = model.getValueAt(i, 1).toString();
                        String Friday  = model.getValueAt(i, 1).toString();
                        
                        String sqlQuery = "INSERT INTO ieattendance (Student No., Last Name, First Name, Last Name, Monday, Tuesday, Wedsnesday, Thursday, Friday) VALUES ('"+Studno+"','"+LastName+"'"+FirstName+"''"+MiddleName+"''"+Monday+"''"+Tuesday+"''"+Wednesday+"''"+Thursday+"''"+Friday+"')";
                        
                        st.addBatch(sqlQuery);
                    }
                int[] rowsInserted = st.executeBatch();
                System.out.println("rows Inserted Count = " + rowsInserted.length);
                    
                } catch (SQLException ex) {
                    System.out.println(e);
                }
                
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
           IEFrame.dispose();
           IESectionRecord IE = new IESectionRecord();
           IE.IESectionRecord();
        }
    }
}
