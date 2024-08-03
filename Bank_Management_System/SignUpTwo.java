package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener
{

    
    JComboBox religion, category , income, edu, ocu;
    JTextField voterTextField, panTextField , adrTextField;
    JButton next;
    JRadioButton senior, notsenior, yacc, nacc;
    String formno;
    
    SignUpTwo(String formno)
    {
        this.formno = formno;

        setTitle("Prateek's Bank");

        setLayout(null);

        

        JLabel AdditionlDetails = new JLabel("Page 2 : Additional Details");
        AdditionlDetails.setFont(new Font("Raleway", Font.BOLD,18));
        AdditionlDetails.setBounds(260, 50, 400, 25);
        add(AdditionlDetails);

        JLabel rel = new JLabel("Religion");
        rel.setFont(new Font("Raleway", Font.BOLD,16));
        rel.setBounds(130, 95, 200, 25);
        add(rel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(270, 95, 280, 25);
        add(religion);

        JLabel cat = new JLabel("Category");
        cat.setFont(new Font("Raleway", Font.BOLD,16));
        cat.setBounds(130, 130, 250, 25);
        add(cat);

        String valcategory[] = {"General", "ST", "OBC", "SC", "Others"};
        category = new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(270, 130, 280, 25);
        add(category);

        JLabel in = new JLabel("Income");
        in.setFont(new Font("Raleway", Font.BOLD,16));
        in.setBounds(130, 165, 200, 25);
        add(in);

        String incomecategory[] = {"Null", "0 - 6 lakh", "6 lakh - 12 lakh", "12 lakh+"};
        income = new JComboBox(incomecategory);
        income.setBackground(Color.WHITE);
        income.setBounds(270, 165, 280, 25);
        add(income);

        JLabel education = new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD,16));
        education.setBounds(130, 200, 200, 25);
        add(education);

        String educationcategory[] = {"6 th Fail", "Non-Graduate", "Graduate", "Post-Graduate","Others"};
        edu = new JComboBox(educationcategory);
        edu.setBounds(270, 200, 280, 25);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel voter = new JLabel("Voter Id no.");
        voter.setFont(new Font("Raleway", Font.BOLD,16));
        voter.setBounds(130, 235, 200, 25);
        add(voter);

        voterTextField = new JTextField();
        voterTextField.setFont(new Font("Raleway", Font.BOLD,16));
        voterTextField.setBounds(270, 235, 280, 25);
        add(voterTextField);

        JLabel occ = new JLabel("Occupation");
        occ.setFont(new Font("Raleway", Font.BOLD,16));
        occ.setBounds(130, 270, 200, 25);
        add(occ);

        String occupation[] = {"Salaried", "Self-Employed", "Bussiness", "Retired","Unemployed","Others"};
        ocu = new JComboBox(occupation);
        ocu.setBounds(270, 270, 280, 25);
        ocu.setBackground(Color.WHITE);
        add(ocu);

        JLabel pan = new JLabel("PAN Number");
        pan.setFont(new Font("Raleway", Font.BOLD,16));
        pan.setBounds(130, 305, 200, 25);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,16));
        panTextField.setBounds(270, 305, 280, 25);
        add(panTextField);

        JLabel add = new JLabel("Aadhar Number");
        add.setFont(new Font("Raleway", Font.BOLD,16));
        add.setBounds(130, 340, 200, 25);
        add(add);

        adrTextField = new JTextField();
        adrTextField.setFont(new Font("Raleway", Font.BOLD,16));
        adrTextField.setBounds(270, 340, 280, 25);
        add(adrTextField);

        JLabel sen = new JLabel("Senior Citizen");
        sen.setFont(new Font("Raleway", Font.BOLD,16));
        sen.setBounds(130, 375, 200, 25);
        add(sen);
        
        senior = new JRadioButton("Yes");
        senior.setBounds(270, 375, 60, 25);
        senior.setBackground(Color.WHITE);
        add(senior);

        notsenior = new JRadioButton("No");
        notsenior.setBounds(350, 375, 70, 25);
        notsenior.setBackground(Color.WHITE);
        add(notsenior);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(senior);
        seniorgroup.add(notsenior);
        
        JLabel exi = new JLabel("Existing Account");
        exi.setFont(new Font("Raleway", Font.BOLD,16));
        exi.setBounds(130, 410, 200, 25);
        add(exi);

        yacc = new JRadioButton("Yes");
        yacc.setBounds(270, 410, 60, 25);
        yacc.setBackground(Color.WHITE);
        add(yacc);

        nacc = new JRadioButton("No");
        nacc.setBounds(350, 410, 70, 25);
        nacc.setBackground(Color.WHITE);
        add(nacc);

        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(yacc);
        accgroup.add(nacc);

        next = new JButton("Next");
        next.setBounds(600, 410, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(800,500);
        setLocation(300,160);
    }

    public void actionPerformed(ActionEvent ae)
    {
       
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String sedu = (String) edu.getSelectedItem();

        String voter = voterTextField.getText();

        String socu = (String) ocu.getSelectedItem();

        String pan = panTextField.getText();
        String adr = adrTextField.getText();

        String sen = null;
        if(senior.isSelected())
        {
            sen = "Yes";
        }
        else if(notsenior.isSelected())
        {
            sen = "No";
        }
        
        String exi = null;
        if(yacc.isSelected())
        {
            exi = "Yes";
        }
        else if(nacc.isSelected())
        {
            exi = "No";
        }
        
        try 
        {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"','"+sedu+"','"+voter+"','"+socu+"','"+pan+"','"+adr+"','"+sen+"', '"+exi+"')";

            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        } 
        
        catch (Exception e) 
        {
            System.out.println(e);    
        }
    }

    public static void main(String args [])
    {
        new SignUpTwo("");
    }

}
