package DICT;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class DICTStudentGrade extends JFrame implements ActionListener {

    JFrame DICTFrame;
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

    private final String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
    private final String user = "root";
    private final String password = "root";

    public DICTStudentGrade() {
        DICTFrame = new JFrame();
        DICTFrame.setTitle("Student Grade");
        DICTFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DICTFrame.setPreferredSize(new Dimension(1000, 800));
        DICTFrame.getContentPane().setBackground(new Color(0, 74, 173));
        DICTFrame.setLayout(null);
        DICTFrame.pack();
        DICTFrame.setLocationRelativeTo(null);
        DICTFrame.setResizable(false);

        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 222, 89));
        headerPanel.setBounds(0, 0, 1000, 125);
        headerPanel.setLayout(new BorderLayout());

        schoollogoyellow = new ImageIcon("tniyellowsmall.png");
        Image resizedlogoyellow = schoollogoyellow.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon finallogoyellow = new ImageIcon(resizedlogoyellow);
        JLabel logoyellow = new JLabel(finallogoyellow);
        logoyellow.setBounds(160, 0, 130, 130);
        headerPanel.add(logoyellow);

        headerLabel = new JLabel("STUDENT GRADE RECORD");
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Trajan Pro", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        subheaderLabel = new JLabel("Course - DICT", SwingConstants.CENTER);
        subheaderLabel.setBounds(0, 60, 1000, 50);
        subheaderLabel.setForeground(Color.BLACK);
        subheaderLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
        DICTFrame.add(subheaderLabel);

        model = new DefaultTableModel(new Object[]{"Student No. ", "Last Name", "First Name", "Middle Name", "English", "Mathematics", "Science", "Filipino"}, 0);
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
        String[] choices = {"1.0", "1.50", "2.0"};
        JComboBox<String> gradeComboBox = new JComboBox<>(choices);

        for (int i = 4; i <= 7; i++) { // Adjusted to match the number of columns
            try {
                TableColumn column = columnModel.getColumn(i);
                column.setCellEditor(new DefaultCellEditor(gradeComboBox));
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
        DICTFrame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Serif", Font.BOLD, 16));
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(new Color(255, 222, 89));
        searchButton.setOpaque(true);
        searchButton.setBorder(new LineBorder(Color.BLACK, 1));
        searchButton.setBounds(370, 150, 100, 30);
        searchButton.addActionListener(this);
        DICTFrame.add(searchButton);

        DICTFrame.add(scrollPane);
        DICTFrame.add(headerPanel);
        DICTFrame.add(delButton);
        DICTFrame.add(updateButton);
        DICTFrame.add(returnButton);

        DICTFrame.setVisible(true);
        DICTFrame.pack();

        displayDataFromDatabase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delButton) {
            deleteDataFromDatabaseAndTable();
        }

        if (e.getSource() == updateButton) {
            updateDataInDatabase();
        }

        if (e.getSource() == returnButton) {
            DICTFrame.dispose();
            new DICTSectionRecord().DICTSectionRecord();
        }

        if (e.getSource() == searchButton) {
            String searchText = searchField.getText().trim();
            if (!searchText.isEmpty()) {
                searchInTable(searchText);
            }
        }
    }

    private void updateDataInDatabase() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            for (int i = 0; i < model.getRowCount(); i++) {
                String studentNo = model.getValueAt(i, 0).toString();
                String lastName = model.getValueAt(i, 1).toString();
                String firstName = model.getValueAt(i, 2).toString();
                String middleName = model.getValueAt(i, 3).toString();
                String english = model.getValueAt(i, 4).toString();
                String mathematics = model.getValueAt(i, 5).toString();
                String science = model.getValueAt(i, 6).toString();
                String filipino = model.getValueAt(i, 7).toString();

                String sqlQuery = "UPDATE bsitgrade SET LastName = '" + lastName + "', FirstName = '" + firstName
                        + "', MiddleName = '" + middleName + "', English = '" + english + "', Mathematics = '" + mathematics
                        + "', Science = '" + science + "', Filipino = '" + filipino + "' WHERE StudentNo = '" + studentNo + "'";

                st.executeUpdate(sqlQuery);
            }

            conn.close();
            JOptionPane.showMessageDialog(DICTFrame, "Data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(DICTFrame, "Error updating data in database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDataFromDatabaseAndTable() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            int[] selectedRows = table.getSelectedRows();

            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String studentNo = model.getValueAt(selectedRows[i], 0).toString();
                String sqlQuery = "DELETE FROM bsitgrade WHERE StudentNo = '" + studentNo + "'";
                st.executeUpdate(sqlQuery);
                model.removeRow(selectedRows[i]);
            }

            conn.close();
            JOptionPane.showMessageDialog(DICTFrame, "Data deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(DICTFrame, "Error deleting data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayDataFromDatabase() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String query = "SELECT * FROM bsitgrade";
            ResultSet rs = st.executeQuery(query);

            model.setRowCount(0);

            while (rs.next()) {
                String studNo = rs.getString("StudentNo");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String middleName = rs.getString("MiddleName");
                String english = rs.getString("English");
                String mathematics = rs.getString("Mathematics");
                String science = rs.getString("Science");
                String filipino = rs.getString("Filipino");

                model.addRow(new Object[]{studNo, lastName, firstName, middleName, english, mathematics, science, filipino});
            }

            st.close();
            conn.close();

        } catch (SQLException ex) {
            System.err.println("Error fetching data: " + ex.getMessage());
        }
    }

    private void searchInTable(String searchText) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        sorter.setRowFilter(rowFilter);
    }
}