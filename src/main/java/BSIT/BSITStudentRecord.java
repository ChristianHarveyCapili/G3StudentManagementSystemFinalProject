package BSIT;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class BSITStudentRecord extends JFrame implements ActionListener {

    JFrame BSITFrame;
    JPanel headerPanel;
    JLabel headerLabel, subheaderLabel, searchLabel;
    JTextField searchField;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton addButton, returnButton, delButton, updateButton, searchButton;
    ImageIcon schoollogoyellow;

    private final String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
    private final String user = "root";
    private final String password = "root";

    public BSITStudentRecord() {
        BSITFrame = new JFrame();
        BSITFrame.setTitle("Student Information Record");
        BSITFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BSITFrame.setPreferredSize(new Dimension(1000, 800));
        BSITFrame.getContentPane().setBackground(new Color(0, 74, 173));
        BSITFrame.setLayout(null);
        BSITFrame.pack();
        BSITFrame.setLocationRelativeTo(null);
        BSITFrame.setResizable(false);
        BSITFrame.setVisible(true);

        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 1000, 125);
        headerPanel.setLayout(new BorderLayout());

        schoollogoyellow = new ImageIcon("tniyellowsmall.png");
        Image resizedlogoyellow = schoollogoyellow.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(150, 0, 130, 125);
        headerPanel.add(logoyellow);

        headerLabel = new JLabel("STUDENT INFORMATION RECORD");
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        subheaderLabel = new JLabel("Course - BSIT", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 60, 1000, 50);
        subheaderLabel.setForeground(Color.BLACK);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        BSITFrame.add(subheaderLabel);

        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "Age", "Birthday", "Gender", "Contact No."}, 0);
        table = new JTable(model);
        table.setOpaque(false);
        table.setBackground(new Color(245, 245, 220));

        tableHeader = table.getTableHeader();
        table.getTableHeader().setBackground(new Color(255, 222, 89));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 13));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 200, 900, 500);

        tableBorderColor = new Color(0, 0, 0);
        scrollPane.setBorder(new LineBorder(tableBorderColor, 8));

        String[] choices = {"Male", "Female"};
        JComboBox<String> gender = new JComboBox<>(choices);
        table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(gender));

        addButton = new JButton("Add Student");
        addButton.setFont(new Font("Serif", Font.BOLD, 16));
        addButton.setForeground(Color.BLACK);
        addButton.setBackground(new Color(255, 222, 89));
        addButton.setOpaque(true);
        addButton.setBorder(new LineBorder(Color.BLACK, 1));
        addButton.setBounds(50, 710, 150, 30);
        addButton.addActionListener(this);

        delButton = new JButton("Delete Student");
        delButton.setFont(new Font("Serif", Font.BOLD, 16));
        delButton.setForeground(Color.BLACK);
        delButton.setBackground(new Color(255, 222, 89));
        delButton.setOpaque(true);
        delButton.setBorder(new LineBorder(Color.BLACK, 1));
        delButton.setBounds(220, 710, 150, 30);
        delButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Serif", Font.BOLD, 16));
        updateButton.setForeground(Color.BLACK);
        updateButton.setBackground(new Color(255, 222, 89));
        updateButton.setOpaque(true);
        updateButton.setBorder(new LineBorder(Color.BLACK, 1));
        updateButton.setBounds(390, 710, 150, 30);
        updateButton.addActionListener(this);

        returnButton = new JButton("Return");
        returnButton.setFont(new Font("Serif", Font.BOLD, 16));
        returnButton.setForeground(Color.BLACK);
        returnButton.setBackground(new Color(255, 222, 89));
        returnButton.setOpaque(true);
        returnButton.setBorder(new LineBorder(Color.BLACK, 1));
        returnButton.setBounds(560, 710, 150, 30);
        returnButton.addActionListener(this);

        searchField = new JTextField(20);
        searchField.setBounds(110, 150, 250, 30);
        BSITFrame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Serif", Font.BOLD, 16));
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(new Color(255, 222, 89));
        searchButton.setOpaque(true);
        searchButton.setBorder(new LineBorder(Color.BLACK, 1));
        searchButton.setBounds(370, 150, 100, 30);
        searchButton.addActionListener(this);
        BSITFrame.add(searchButton);

        DisplayData();

        BSITFrame.add(scrollPane);
        BSITFrame.add(headerPanel);
        BSITFrame.add(addButton);
        BSITFrame.add(delButton);
        BSITFrame.add(updateButton);
        BSITFrame.add(returnButton);

        BSITFrame.pack();
        BSITFrame.setVisible(true);
    }

    private void addRow() {
        model.addRow(new Object[]{"", "", "", "", "", "", "Select Gender", ""});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            BSITFrame.dispose();
            BSITStudentForm sa = new BSITStudentForm();
        }

        if (e.getSource() == delButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String studentNo = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                DeleteData(studentNo);
                JOptionPane.showMessageDialog(BSITFrame, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(BSITFrame, "Error! Please select row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == updateButton) {
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String studentNo = model.getValueAt(i, 0).toString();
                String lastName = model.getValueAt(i, 1).toString();
                String firstName = model.getValueAt(i, 2).toString();
                String middleName = model.getValueAt(i, 3).toString();
                String age = model.getValueAt(i, 4).toString();
                String birthday = model.getValueAt(i, 5).toString();
                String gender = model.getValueAt(i, 6).toString();
                String contactNo = model.getValueAt(i, 7).toString();

                UpdateData(studentNo, "LastName", lastName);
                UpdateData(studentNo, "FirstName", firstName);
                UpdateData(studentNo, "MiddleName", middleName);
                UpdateData(studentNo, "Age", age);
                UpdateData(studentNo, "Birthday", birthday);
                UpdateData(studentNo, "Gender", gender);
                UpdateData(studentNo, "ContactNo", contactNo);
            }
            JOptionPane.showMessageDialog(BSITFrame, "Data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == returnButton) {
            BSITFrame.dispose();
            BSITSectionRecord bs = new BSITSectionRecord();
            bs.BSITSectionRecord();
        }

        if (e.getSource() == searchButton) {
            String searchText = searchField.getText().trim().toLowerCase();
            searchInTable(searchText);
        }
    }

    private void DeleteData(String studentNo) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String sqlQuery = "DELETE FROM bsitstudinfo WHERE StudentNo = '" + studentNo + "'";
            st.executeUpdate(sqlQuery);

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BSITFrame, "Error deleting student record from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void UpdateData(String studentNo, String columnName, String newValue) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String sqlQuery = "UPDATE bsitstudinfo SET " + columnName + " = '" + newValue + "' WHERE StudentNo = '" + studentNo + "'";
            st.executeUpdate(sqlQuery);

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BSITFrame, "Error updating student record in database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void DisplayData() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bsitstudinfo");
            
            model.setRowCount(0);

            while (rs.next()) {
                String studentNo = rs.getString("StudentNo");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String middleName = rs.getString("MiddleName");
                String age = rs.getString("Age");
                String birthday = rs.getString("Birthday");
                String gender = rs.getString("Gender");
                String contactNo = rs.getString("ContactNo");

                model.addRow(new Object[]{studentNo, lastName, firstName, middleName, age, birthday, gender, contactNo});
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BSITFrame, "Error fetching data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchInTable(String searchText) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        sorter.setRowFilter(rowFilter);
    }

    class StudentInfoDialog extends JFrame {

        public StudentInfoDialog(String studentNo, String lastName, String firstName, String middleName, String age, String birthday, String gender, String contactNo) {
            setTitle("Student Information");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(BSITFrame);
            setLayout(new BorderLayout());
            getContentPane().setBackground(new Color(255, 222, 89));

            JLabel infoLabel = new JLabel("<html><b>Student No.:</b> " + studentNo + "<br>"
                    + "<b>Last Name:</b> " + lastName + "<br>"
                    + "<b>First Name:</b> " + firstName + "<br>"
                    + "<b>Middle Name:</b> " + middleName + "<br>"
                    + "<b>Age:</b> " + age + "<br>"
                    + "<b>Birthday:</b> " + birthday + "<br>"
                    + "<b>Gender:</b> " + gender + "<br>"
                    + "<b>Contact No.:</b> " + contactNo + "</html>");
            infoLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);

            add(infoLabel, BorderLayout.CENTER);

            setVisible(true);
        }
    }
}