package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;

    FastCash(String pinnumber)
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

        JLabel text = new JLabel("SELECT  WITHDRAWAL  AMOUNT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        label.add(balanceenquiry);
  
        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        label.add(exit);


        getContentPane().setBackground(Color.WHITE);

        setSize(900, 900);
        setLocation(260, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);

            Conn c = new Conn();
            try 
            {
                ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinnumber+"'");
                int balance = 0;
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

                if (ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }



    public static void main(String args [])
    {
        new FastCash("");
    }
    
}
