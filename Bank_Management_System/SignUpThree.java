package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;
        setTitle("Prateek's Bank");

        setLayout(null);

        JLabel AccountDetails = new JLabel("Page 3 : Account Details");
        AccountDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        AccountDetails.setBounds(260, 50, 400, 25);
        add(AccountDetails);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(130, 95, 250, 25);
        add(type);

        r1 = new JRadioButton("Fixed Deposit Account");
        r1.setBounds(140, 120, 170, 25);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(140, 150, 170, 25);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Recurring Account");
        r3.setBounds(320, 120, 170, 25);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Savings Account");
        r4.setBounds(320, 150, 170, 25);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup typegroup = new ButtonGroup();
        typegroup.add(r1);
        typegroup.add(r2);
        typegroup.add(r3);
        typegroup.add(r4);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(130, 200, 200, 25);
        add(card);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 8));
        carddetails.setBounds(130, 215, 200, 25);
        add(carddetails);

        JLabel no = new JLabel("xxxx xxxx xxxx 2341");
        no.setFont(new Font("Raleway", Font.BOLD, 18));
        no.setBounds(330, 200, 200, 25);
        add(no);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(130, 250, 200, 25);
        add(pin);

        JLabel pindetails = new JLabel("Your 4 Digit Pin");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 8));
        pindetails.setBounds(130, 265, 200, 25);
        add(pindetails);

        JLabel pno = new JLabel("xxxx");
        pno.setFont(new Font("Raleway", Font.BOLD, 18));
        pno.setBounds(330, 250, 200, 25);
        add(pno);

        JLabel services = new JLabel("Other Services :");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(130, 300, 200, 25);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(140, 325, 150, 25);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(140, 345, 150, 25);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(140, 365, 150, 25);
        add(c3);

        c4 = new JCheckBox("Cheque Box");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(320, 325, 150, 25);
        add(c4);

        c5 = new JCheckBox("Emails & SMS Alerts");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(320, 345, 150, 25);
        add(c5);

        c5 = new JCheckBox("E-Statement");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(320, 365, 150, 25);
        add(c5);

        c7 = new JCheckBox("i hereby declare that the above information are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(140, 430, 320, 25);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(500, 410, 80, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(600, 410, 80, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setVisible(true);
        setSize(800, 500);
        setLocation(300, 160);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String type = null;
            if (r1.isSelected()) {
                type = "Fixed Deposite";
            } else if (r2.isSelected()) {
                type = "Current Account";
            } else if (r3.isSelected()) {
                type = "Reccuring Account";
            } else if (r4.isSelected()) {
                type = "Savings Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 0610030000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card ";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking ";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking ";
            } else if (c4.isSelected()) {
                facility = facility + " Cheque Box ";
            } else if (c5.isSelected()) {
                facility = facility + " Emails & SMS Alerts ";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement ";
            }

            try {

                Conn c = new Conn();

                String query1 = "insert into signupthree values('" + formno + "','" + type + "','" + cardnumber + "','"+ pinnumber + "','" + facility + "')";

                String query2 = "insert into login values('" + formno + "','" + cardnumber + "','"+ pinnumber + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number :" + cardnumber + "\n Pin:" + pinnumber  );

                setVisible(false);
                new Deposit(pinnumber).setVisible(false);

            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }

        } 
        else if (ae.getSource() == cancel) 
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) 
    {
        new SignUpThree("");
    }
}
