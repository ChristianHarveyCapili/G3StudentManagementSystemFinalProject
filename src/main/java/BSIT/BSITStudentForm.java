package BSIT;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BSITStudentForm extends JFrame implements ActionListener {

    JFrame insertFrame;
    JPanel headerPanel;
    JLabel headerLabel, subheaderLabel;
    JPanel panel;
    JLabel studentNoLabel, lastNameLabel, firstNameLabel, middleNameLabel;
    JTextField studentNoField, lastNameField, firstNameField, middleNameField;
    JButton submitButton, returnButton;
    ImageIcon schoollogoyellow;

    // Database credentials
    private final String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
    private final String user = "root";
    private final String password = "root";

    public BSITStudentForm() {
        insertFrame = new JFrame();
        insertFrame.setTitle("Student Form");
        insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        insertFrame.setPreferredSize(new Dimension(550, 600));
        insertFrame.getContentPane().setBackground(new Color(0, 74, 173));
        insertFrame.setLayout(null);
        insertFrame.pack();
        insertFrame.setLocationRelativeTo(null);
        insertFrame.setResizable(false);
        insertFrame.setVisible(true);

        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 550, 100);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout to center components

        schoollogoyellow = new ImageIcon("tniyellowsmall.png");
        Image resizedlogoyellow = schoollogoyellow.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(20, 0, 100, 100);
        headerPanel.add(logoyellow);

        headerLabel = new JLabel("STUDENT FORM");
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 16));
        headerPanel.add(headerLabel);

        insertFrame.add(headerPanel);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 120, 430, 400);
        panel.setBackground(new Color(255, 222, 89));

        studentNoLabel = new JLabel("Student No.:");
        studentNoLabel.setForeground(Color.BLACK);
        studentNoLabel.setFont(new Font("Trajan Pro", Font.BOLD, 14));
        studentNoLabel.setBounds(75, 45, 100, 20);
        panel.add(studentNoLabel);

        studentNoField = new JTextField();
        studentNoField.setBounds(185, 45, 150, 30);
        studentNoField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(studentNoField);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.BLACK);
        lastNameLabel.setFont(new Font("Trajan Pro", Font.BOLD, 14));
        lastNameLabel.setBounds(75, 95, 100, 20);
        panel.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(185, 95, 150, 30);
        lastNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(lastNameField);

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.BLACK);
        firstNameLabel.setFont(new Font("Trajan Pro", Font.BOLD, 14));
        firstNameLabel.setBounds(75, 145, 100, 20);
        panel.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(185, 145, 150, 30);
        firstNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(firstNameField);

        middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setForeground(Color.BLACK);
        middleNameLabel.setFont(new Font("Trajan Pro", Font.BOLD, 14));
        middleNameLabel.setBounds(75, 195, 100, 20);
        panel.add(middleNameLabel);

        middleNameField = new JTextField();
        middleNameField.setBounds(185, 195, 150, 30);
        middleNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(middleNameField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 240, 100, 30);
        
        submitButton.addActionListener(this);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(submitButton);

        returnButton = new JButton("Return");
        returnButton.setBounds(20, 350, 100, 30);
        
        returnButton.addActionListener(this);
        returnButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(returnButton);

        insertFrame.add(panel);
        insertFrame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String studentNo = studentNoField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String firstName = firstNameField.getText().trim();
            String middleName = middleNameField.getText().trim();

            insertData(studentNo, lastName, firstName, middleName, "bsitstudinfo");
            insertData(studentNo, lastName, firstName, middleName, "bsitgrade");
            insertData(studentNo, lastName, firstName, middleName, "bsitattendance");

            JOptionPane.showMessageDialog(insertFrame, "Data Submited.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == returnButton) {
            insertFrame.dispose();
            BSITStudentRecord br = new BSITStudentRecord();
        }
    }

    private void insertData(String studentNo, String lastName, String firstName, String middleName, String tableName) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String sqlQuery = "";

            if (tableName.equals("bsitstudinfo")) {
                sqlQuery = "INSERT INTO bsitstudinfo (StudentNo, LastName, FirstName, MiddleName) VALUES ('"
                        + studentNo + "','" + lastName + "','" + firstName + "','" + middleName + "')";
            } else if (tableName.equals("bsitgrade")) {
                sqlQuery = "INSERT INTO bsitgrade (StudentNo, LastName, FirstName, MiddleName, English, Mathematics, Science, Filipino) " +
                        "VALUES ('" + studentNo + "','" + lastName + "','" + firstName + "','" + middleName + "', '', '', '', '')";
            } else if (tableName.equals("bsitattendance")) {
                sqlQuery = "INSERT INTO bsitattendance (StudentNo, LastName, FirstName, MiddleName, Monday, Tuesday, Wednesday, Thursday, Friday) " +
                        "VALUES ('" + studentNo + "','" + lastName + "','" + firstName + "','" + middleName + "', '', '', '', '', '')";
            }

            st.executeUpdate(sqlQuery);

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(insertFrame, "Error inserting data into database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
}