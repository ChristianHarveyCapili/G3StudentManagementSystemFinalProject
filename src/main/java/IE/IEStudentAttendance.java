package IE;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class IEStudentAttendance extends JFrame implements ActionListener {

    JFrame IEFrame;
    JPanel headerPanel;
    JLabel headerLabel, subheaderLabel, searchLabel;
    JTextField searchField;
    JTable table;
    Color tableBorderColor;
    JTableHeader tableHeader;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton delButton, updateButton, returnButton, searchButton;
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

        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 1000, 125);
        headerPanel.setLayout(new BorderLayout());

        schoollogoyellow = new ImageIcon("tniyellowsmall.png");
        Image resizedlogoyellow = schoollogoyellow.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(160, 0, 130, 125);
        headerPanel.add(logoyellow);

        headerLabel = new JLabel("STUDENT ATTENDANCE RECORD");
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        subheaderLabel = new JLabel("Course - BSIE", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 60, 1000, 50);
        subheaderLabel.setForeground(Color.BLACK);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        IEFrame.add(subheaderLabel);

        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}, 0);
        table = new JTable(model);
        table.setOpaque(false);
        table.setBackground(new Color(245, 245, 220));

        tableHeader = table.getTableHeader();
        tableHeader.setBackground(new Color(255, 222, 89));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setFont(new Font("Arial Black", Font.BOLD, 13));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 200, 900, 500);

        tableBorderColor = new Color(0, 0, 0);
        scrollPane.setBorder(new LineBorder(tableBorderColor, 8));

        TableColumnModel columnModel = table.getColumnModel();
        String[] choices = {"Present", "Absent", "Excuse"};
        JComboBox<String> attendanceComboBox = new JComboBox<>(choices);

        for (int i = 4; i <= 8; i++) {
            try {
                TableColumn column = columnModel.getColumn(i);
                column.setCellEditor(new DefaultCellEditor(attendanceComboBox));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Error: Column index " + i + " is out of bounds. Skipping.");
            }
        }

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
        IEFrame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Serif", Font.BOLD, 16));
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(new Color(255, 222, 89));
        searchButton.setOpaque(true);
        searchButton.setBorder(new LineBorder(Color.BLACK, 1));
        searchButton.setBounds(370, 150, 100, 30);
        searchButton.addActionListener(this);
        IEFrame.add(searchButton);

        IEFrame.add(scrollPane);
        IEFrame.add(headerPanel);
        IEFrame.add(delButton);
        IEFrame.add(updateButton);
        IEFrame.add(returnButton);

        IEFrame.setVisible(true);
        IEFrame.pack();

        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String sqlQuery = "SELECT * FROM bsitattendance";
            ResultSet rs = st.executeQuery(sqlQuery);

            model.setRowCount(0);

            while (rs.next()) {
                String studentNo = rs.getString("StudentNo");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String middleName = rs.getString("MiddleName");
                String monday = rs.getString("Monday");
                String tuesday = rs.getString("Tuesday");
                String wednesday = rs.getString("Wednesday");
                String thursday = rs.getString("Thursday");
                String friday = rs.getString("Friday");

                model.addRow(new Object[]{studentNo, lastName, firstName, middleName, monday, tuesday, wednesday, thursday, friday});
            }

            conn.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String studentNo = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                deleteDataFromDatabase(studentNo);
            } else {
                JOptionPane.showMessageDialog(this, "Error! Please select row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == updateButton) {
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String studentNo = model.getValueAt(i, 0).toString();
                String lastName = model.getValueAt(i, 1).toString();
                String firstName = model.getValueAt(i, 2).toString();
                String middleName = model.getValueAt(i, 3).toString();
                String monday = model.getValueAt(i, 4).toString();
                String tuesday = model.getValueAt(i, 5).toString();
                String wednesday = model.getValueAt(i, 6).toString();
                String thursday = model.getValueAt(i, 7).toString();
                String friday = model.getValueAt(i, 8).toString();

                updateDataInDatabase(studentNo, "LastName", lastName);
                updateDataInDatabase(studentNo, "FirstName", firstName);
                updateDataInDatabase(studentNo, "MiddleName", middleName);
                updateDataInDatabase(studentNo, "Monday", monday);
                updateDataInDatabase(studentNo, "Tuesday", tuesday);
                updateDataInDatabase(studentNo, "Wednesday", wednesday);
                updateDataInDatabase(studentNo, "Thursday", thursday);
                updateDataInDatabase(studentNo, "Friday", friday);
            }
        }

        if (e.getSource() == returnButton) {
            IEFrame.dispose();
            IESectionRecord bs = new IESectionRecord();
            bs.IESectionRecord();
        }

        if (e.getSource() == searchButton) {
            String searchTerm = searchField.getText();
            searchInTable(searchTerm);
        }
    }

    private void deleteDataFromDatabase(String studentNo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sqlQuery = "DELETE FROM bsitattendance WHERE StudentNo=?";
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, studentNo);
            ps.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDataInDatabase(String studentNo, String columnName, String columnValue) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sqlQuery = "UPDATE bsitattendance SET " + columnName + "=? WHERE StudentNo=?";
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, columnValue);
            ps.setString(2, studentNo);
            ps.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating data in database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchInTable(String searchTerm) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchTerm);
        sorter.setRowFilter(rowFilter);
    }
}