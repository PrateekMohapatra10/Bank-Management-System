package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;

    Transactions(String pinnumber)
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

        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(225, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        label.add(balanceenquiry);
  
        exit = new JButton("Exit");
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
            System.exit(0);
        }
        else if (ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl)
        {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == ministatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }



    public static void main(String args [])
    {
        new Transactions("");
    }
    
}
