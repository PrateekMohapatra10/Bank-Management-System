package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener 
{
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    Withdrawal(String pinnumber)
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

        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180, 350, 300, 30);
        label.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
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
        
        if(ae.getSource() == withdraw)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To withdwar");
            }
            else
            {
                try
                {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"' )";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +number+ " Withdrawed Successfully");

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
        new Withdrawal("");
    }
    
}


