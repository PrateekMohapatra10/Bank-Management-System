package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() 
    {
        setTitle("Prateek's Bank");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Prateek's Bank");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(180, 40, 900, 40);
        add(text);

        JLabel cardno = new JLabel("Card No. :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 30));
        cardno.setBounds(130, 150, 200, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(290, 150, 300, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 25));
        add(cardTextField);

        JLabel pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(130, 220, 200, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(290, 220, 300, 40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 25));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(290, 300, 120, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(470, 300, 120, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(290, 350, 300, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 500);
        setLocation(300, 160);
        setVisible(true);
    }  
    
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where Card_Number = '" + cardnumber + "'and Pin_Number = '" + pinnumber+"'";
            try 
            {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) 
    {
        new Login();
    }
}
