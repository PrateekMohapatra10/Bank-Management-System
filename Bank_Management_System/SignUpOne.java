package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpOne extends JFrame  implements ActionListener
{

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried;

    SignUpOne() 
    {

        setTitle("Prateek's Bank");

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Osward", Font.BOLD, 30));
        formno.setBounds(180, 5, 500, 40);
        add(formno);

        JLabel PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        PersonalDetails.setBounds(260, 50, 400, 25);
        add(PersonalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(130, 95, 200, 25);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(270, 95, 280, 25);
        add(nameTextField);

        JLabel fname = new JLabel("Fathers Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 16));
        fname.setBounds(130, 130, 250, 25);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setBounds(270, 130, 280, 25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(130, 165, 200, 25);
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        dobTextField.setBounds(270, 165, 280, 25);
        add(dobTextField);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(130, 200, 200, 25);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(270, 200, 60, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(350, 200, 70, 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(130, 235, 200, 25);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        emailTextField.setBounds(270, 235, 280, 25);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 16));
        marital.setBounds(130, 270, 200, 25);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(270, 270, 80, 25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(350, 270, 120, 25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel add = new JLabel("Address :");
        add.setFont(new Font("Raleway", Font.BOLD, 16));
        add.setBounds(130, 305, 200, 25);
        add(add);

        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        addTextField.setBounds(270, 305, 280, 25);
        add(addTextField);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(130, 340, 200, 25);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        cityTextField.setBounds(270, 340, 280, 25);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(130, 375, 200, 25);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        stateTextField.setBounds(270, 375, 280, 25);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 16));
        pincode.setBounds(130, 410, 200, 25);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        pincodeTextField.setBounds(270, 410, 280, 25);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBounds(600, 410, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(800, 500);
        setLocation(300, 160);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();

        String gender = null;
        if (male.isSelected()) 
        {
            gender = "Male";
        }
        else if (female.isSelected()) 
        {
            gender = "Female";
        }

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected()) 
        {
            marital = "Married";
        } 
        else if (unmarried.isSelected()) 
        {
            marital = "Unmarried";
        }

        String add = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try  
        {
            if (name.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } 
            if (fname.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Fathers Name is Required");
            }
            if (dob.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Date Of Birth is Required");
            }
            // if (gender.equals("")) 
            // {
            //     JOptionPane.showMessageDialog(null, "Gender is Required");
            // }
            if (email.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            // if (marital.equals("")) 
            // {
            //     JOptionPane.showMessageDialog(null, "Marital Status is Required");
            // }
            if (add.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            if (city.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            if (state.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            if (pincode.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            }

            else 
            {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "','" + gender + "','" + email + "','" + marital + "','" + add + "','" + city + "','" + state + "','" + pincode + "')";

                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);

            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public static void main(String args[]) 
    {
        new SignUpOne();
    }
}