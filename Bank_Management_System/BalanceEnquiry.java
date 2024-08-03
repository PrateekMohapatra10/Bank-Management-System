package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber)
    {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        back = new JButton("Back");
        back.setBounds(355, 510, 150, 30);
        back.addActionListener(this);
        label.add(back);

        Conn c = new Conn();
        int balance = 0;
        try 
        {
            ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinnumber+"'");
                
            while(rs.next())
            {
                if(rs.getString("Type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("Amount")); 
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }   
        
        JLabel text = new JLabel("Your Current Account Balance Is: " +balance);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        setSize(900, 900);
        setLocation(260, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
