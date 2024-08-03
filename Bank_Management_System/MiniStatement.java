package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame
{
    MiniStatement(String pinnumber)
    {

        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20,140,900,200);
        add(mini);

        JLabel bank = new JLabel();
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 1100, 300, 20);
        balance.setFont(new Font("Raleway", Font.BOLD, 18));
        add(balance);


        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_Number = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: " + rs.getString("Card_Number").substring(0,4) + "XXXXXXXX" + rs.getString("Card_Number").substring(12));
            }
        }
        
        catch (Exception e) 
        {
            System.out.println(e);
        }
    

        try 
        {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");

                if(rs.getString("Type").equals("Deposit"))
                    {
                        bal += Integer.parseInt(rs.getString("Amount")); 
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("Amount"));
                    }
            }  
            balance.setText("Your Current Account Balance Is Rs " + bal);     
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }



        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new MiniStatement("");
    }
}
