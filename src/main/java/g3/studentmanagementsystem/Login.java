/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g3.studentmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Harvey
 */
public class Login implements ActionListener {
     
    // Adding all components
    
    JFrame frame = new JFrame();
    JLabel messageLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel ("Username:");
    JLabel passwordLabel = new JLabel ("Password:");  
    JLabel messagesLabel = new JLabel();
    HashMap<String,String> login = new HashMap<String,String>();
   
    Login(HashMap<String,String> loginOriginal){
        //Add all components in JFrame
        
        login = loginOriginal;
        
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600 );
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.blue);
        frame.setResizable(false);
        
        ImageIcon image = new ImageIcon ("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\Project\\src\\main\\java\\Images\\Logo.png");
        Image images = image.getImage();
        Image pic =images.getScaledInstance(frame.getWidth()/2, frame.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(pic);
        
        JLabel imageLabel = new JLabel (image);
        imageLabel.setIcon(image);
        imageLabel.setBounds(0, 0, frame.getWidth()/2, frame.getHeight());
        frame.getContentPane().add(imageLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(300,0, frame.getWidth()-300,frame.getHeight());
        panel.setVisible(true);
        panel.setBackground(Color.yellow);
        frame.getContentPane().add(panel);
        
        messageLabel.setBounds(70,50,panel.getWidth()-20,35);
        messageLabel.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        messageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(messageLabel);
        
        //Declaring the component's location
        usernameLabel.setBounds(100, 350, 75, 25);
        panel.add(usernameLabel);
        
        passwordLabel.setBounds(100,400, 75, 25);
        panel.add(passwordLabel);
        
        usernameField.setBounds(200, 350, 200, 25);
        panel.add(usernameField);
         
        passwordField.setBounds(200, 400, 200, 25);
        panel.add(passwordField);
        
        loginButton.setBounds(140, 450,100 , 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        panel.add(loginButton);
        
        resetButton.setBounds(260, 450, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        panel.add(resetButton);
        
        messagesLabel.setBounds(180,250,panel.getWidth()-100,25);
        messagesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(messagesLabel);
        
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }
        
        if(e.getSource()==loginButton) {
            
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            
            if(login.containsKey(username)){
                if(login.get(username).equals(password)){
                    messagesLabel.setForeground(Color.BLUE);
                    messagesLabel.setText("Login Successful!");
                    frame.dispose();
                    StudentSection sc = new StudentSection();
                }
                else {
                    messagesLabel.setForeground(Color.red);
                    messagesLabel.setText("Invalid Password. Please try again!");
                }
            }
            else {
                    messagesLabel.setForeground(Color.red);
                    messagesLabel.setText("Username not found. Please try again!");
            }
       }
   }
}
