package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{

    JPasswordField pin, repin;
    JButton Change, back;
    String pinnumber;

    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(235, 320, 700, 35);
        text.setForeground(Color.WHITE);
        label.add(text);

        

        JLabel pintext = new JLabel("New Pin : ");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 370, 180, 25);
        pintext.setForeground(Color.WHITE);
        label.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(320,370,180,25);
        label.add(pin);

        JLabel repintext = new JLabel("Re-Enter New Pin : ");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 410, 180, 25);
        repintext.setForeground(Color.WHITE);
        label.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(320,410,180,25);
        label.add(repin);

        Change = new JButton("Change");
        Change.setBounds(355, 510, 150, 30);
        Change.addActionListener(this);
        label.add(Change);

        back = new JButton("Back");
        back.setBounds(170, 510, 150, 30);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(900, 900);
        setLocation(260, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Change)
        {
            try
            {
                String npin = pin.getText();
                String rpin = repin.getText(); 
                
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered Pin Does't Match");
                    return;
                }

                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }

                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set Pin = '"+rpin+"' where Pin = '"+pinnumber+"'";
                String query2 = "update login set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";
                String query3 = "update signupthree set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }        
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }

    public static void main(String[] args)
    {
        new PinChange("").setVisible(true);
    }
}
