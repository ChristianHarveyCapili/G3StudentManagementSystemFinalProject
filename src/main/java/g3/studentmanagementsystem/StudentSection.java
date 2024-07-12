
package g3.studentmanagementsystem;

import DIT.*;
import IE.*;
import DICT.*;
import BSIT.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentSection implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("WELCOME TO");
    JLabel welcomesLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
    JLabel selectLabel = new JLabel("Select Student Section:");
    JButton btnIE = new JButton("BSIE COURSE");
    JButton btnBSIT = new JButton("BSIT COURSE");
    JButton btnDICT = new JButton("DICT COURSE");
    JButton btnDIT = new JButton("DIT COURSE");
    private Color yellow = new Color(255, 222, 89);
    private Color blue = new Color(0, 74, 173);
    private ImageIcon schoollogo = new ImageIcon("tnismall.png");
    private JLabel logo = new JLabel(schoollogo);
    JButton btnExit; // Exit button declaration

    public StudentSection() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(blue);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(frame.getWidth() / 2, 0, frame.getWidth() / 2, frame.getHeight());
        panel.setVisible(true);
        panel.setBackground(yellow);
        frame.getContentPane().add(panel);

        welcomeLabel.setBounds(100, 25, panel.getWidth() - 20, 35);
        welcomeLabel.setFont(new Font("Georgia", Font.BOLD, 25));
        welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomeLabel);

        welcomesLabel.setBounds(10, 50, panel.getWidth() - 20, 35);
        welcomesLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        welcomesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomesLabel);

        selectLabel.setBounds(15, 100, panel.getWidth() - 20, 35);
        selectLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        selectLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(selectLabel);


        btnBSIT.setBounds(50, 170, panel.getWidth() - 100, 50);
        btnBSIT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnBSIT.setFocusable(false);
        btnBSIT.addActionListener(this);
        panel.add(btnBSIT);
        
        btnIE.setBounds(50, 240, panel.getWidth() - 100, 50);
        btnIE.setFont(new Font("Verdana", Font.BOLD, 15));
        btnIE.setFocusable(false);
        btnIE.addActionListener(this);
        panel.add(btnIE);

        btnDICT.setBounds(50, 310, panel.getWidth() - 100, 50);
        btnDICT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnDICT.setFocusable(false);
        btnDICT.addActionListener(this);
        panel.add(btnDICT);

        btnDIT.setBounds(50, 380, panel.getWidth() - 100, 50);
        btnDIT.setFont(new Font("Verdana", Font.BOLD, 15));
        btnDIT.setFocusable(false);
        btnDIT.addActionListener(this);
        panel.add(btnDIT);

        logo.setBounds(70, 150, schoollogo.getIconWidth(), schoollogo.getIconHeight());
        frame.add(logo);
        
        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Verdana", Font.BOLD, 15));
        btnExit.setFocusable(false);
        btnExit.addActionListener(this);
        btnExit.setBounds(100, 470,panel.getWidth()-200 , 50);
        panel.add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIE) {
            frame.dispose();
            IESectionRecord IE = new IESectionRecord();
            IE.IESectionRecord();
        } else if (e.getSource() == btnBSIT) {
            frame.dispose();
            BSITSectionRecord bs = new BSITSectionRecord();
            bs.BSITSectionRecord();
        } else if (e.getSource() == btnDICT) {
            frame.dispose();
            DICTSectionRecord dict = new DICTSectionRecord();
            dict.DICTSectionRecord();
        } else if (e.getSource() == btnDIT) {
            frame.dispose();
            DITSectionRecord ts = new DITSectionRecord();
            ts.DITSectionRecord();
        } else if (e.getSource() == btnExit) {
            frame.dispose();
        } else {
            System.out.println("Unexpected button clicked!");
        }
    }
}