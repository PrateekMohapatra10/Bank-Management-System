package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener 
{


    JButton deposit,back;
    JTextField amount;
    String pinnumber;

    Deposit(String pinnumber)
    {

        this.pinnumber = pinnumber;

        setTitle("Prateek's Bank");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Enter The Amount You Want To Deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180, 350, 300, 30);
        label.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(900, 900);
        setLocation(260, 0);
        //setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource() == deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
            }
            else
            {
                try
                {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"' )";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +number+ " Deposited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }

        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
    public static void main(String args[])
    {
        new Deposit("");
    }
    
}
