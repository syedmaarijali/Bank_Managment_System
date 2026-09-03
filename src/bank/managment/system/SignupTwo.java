package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel additionaldetails,religion,category,income,education,occupation,panNum,seniorC,exAcc,qualification,formNum/*l13*/;
    JButton nextb;
    JRadioButton seniorY,seniorN,existingY,existingN;
    JTextField panText,t3;
    JComboBox religionC,categoryC,incomeC,educationC,occupationC;
    String formno;
    SignupTwo(String formno){
        setLayout(null);
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        //JLabel l14 = new JLabel(i3);
        //l14.setBounds(150, 0, 100, 100);
        //add(l14);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        additionaldetails = new JLabel("Additonal Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        
        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        
        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        
        education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        
        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        
        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        
        panNum= new JLabel("PAN Number:");
        panNum.setFont(new Font("Raleway", Font.BOLD, 18));
        
        seniorC = new JLabel("Senior Citizen:");
        seniorC.setFont(new Font("Raleway", Font.BOLD, 18));
        
        exAcc = new JLabel("Existing Account:");
        exAcc.setFont(new Font("Raleway", Font.BOLD, 18));
        
        formNum = new JLabel("Form No:");
        formNum.setFont(new Font("Raleway", Font.BOLD, 13));
        
        /*l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));*/
        
        nextb = new JButton("Next");
        nextb.setFont(new Font("Raleway", Font.BOLD, 14));
        nextb.setBackground(Color.BLACK);
        nextb.setFocusable(false);
        nextb.setForeground(Color.WHITE);
        
        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        seniorY = new JRadioButton("Yes");
        seniorY.setFont(new Font("Raleway", Font.BOLD, 14));
        seniorY.setBackground(Color.WHITE);
        
        seniorN = new JRadioButton("No");
        seniorN.setFont(new Font("Raleway", Font.BOLD, 14));
        seniorN.setBackground(Color.WHITE);
        
        ButtonGroup seniorcit = new ButtonGroup();// Group buttons together so only one can be selected at a time
        seniorcit.add(seniorY);
        seniorcit.add(seniorN);
        
        existingY = new JRadioButton("Yes");
        existingY.setFont(new Font("Raleway", Font.BOLD, 14));
        existingY.setBackground(Color.WHITE);
        
        existingN = new JRadioButton("No");
        existingN.setFont(new Font("Raleway", Font.BOLD, 14));
        existingN.setBackground(Color.WHITE);
        
        ButtonGroup existacc = new ButtonGroup();// Group buttons together so only one can be selected at a time
        existacc.add(existingY);
        existacc.add(existingN);
        
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionC = new JComboBox(valreligion);
        religionC.setBackground(Color.WHITE);
        religionC.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String categoryval[] = {"General","OBC","SC","ST","Other"};
        categoryC = new JComboBox(categoryval);
        categoryC.setBackground(Color.WHITE);
        categoryC.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String incomeval[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeC = new JComboBox(incomeval);
        incomeC.setBackground(Color.WHITE);
        incomeC.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String educationval[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        educationC = new JComboBox(educationval);
        educationC.setBackground(Color.WHITE);
        educationC.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupationval[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationC = new JComboBox(occupationval);
        occupationC.setBackground(Color.WHITE);
        occupationC.setFont(new Font("Raleway", Font.BOLD, 14));
       
        // ------- BOUNDING ------
        formNum.setBounds(700,10,60,30);
        add(formNum);
       /* 
        l13.setBounds(760,10,60,30);
        add(l13);*/
        
        additionaldetails.setBounds(280,30,600,40);
        add(additionaldetails);
        
        religion.setBounds(100,120,100,30);
        add(religion);
        
        religionC.setBounds(350,120,320,30);
        add(religionC);
        
        category.setBounds(100,170,100,30);
        add(category);
        
        categoryC.setBounds(350,170,320,30);
        add(categoryC);
        
        income.setBounds(100,220,100,30);
        add(income);
        
        incomeC.setBounds(350,220,320,30);
        add(incomeC);
        
        education.setBounds(100,270,150,30);
        add(education);
        
        educationC.setBounds(350,270,320,30);
        add(educationC);
        
        qualification.setBounds(100,290,150,30);
        add(qualification);
        
        occupation.setBounds(100,340,150,30);
        add(occupation);
        
        occupationC.setBounds(350,340,320,30);
        add(occupationC);
        
        panNum.setBounds(100,390,150,30);
        add(panNum);
        
        panText.setBounds(350,390,320,30);
        add(panText);

        seniorC.setBounds(100,440,320,30);
        add(seniorC);
        
        seniorY.setBounds(350,440,100,30);
        add(seniorY);
        
        seniorN.setBounds(460,440,100,30);
        add(seniorN);
        
        exAcc.setBounds(100,490,180,30);
        add(exAcc);
        
        existingY.setBounds(350,490,100,30);
        add(existingY);
        
        existingN.setBounds(460,490,100,30);
        add(existingN);
        
        nextb.setBounds(570,540,100,30);
        add(nextb);
        
        nextb.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionC.getSelectedItem(); 
        String category = (String)categoryC.getSelectedItem();
        String income = (String)incomeC.getSelectedItem();
        String education = (String)educationC.getSelectedItem();
        String occupation = (String)occupationC.getSelectedItem();
        
        String pan = panText.getText();
        
        String scitizen = "";
        if(seniorY.isSelected()){ 
            scitizen = "Yes";
        }
        else if(seniorN.isSelected()){ 
            scitizen = "No";
        }
         
        String eaccount = "";
        if(existingY.isSelected()){ 
            eaccount = "Yes";
        }else if(existingN.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(panText.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signuptwo(formno, religion, category, income, education, occupation, pan, seniorcitizen, existingaccount ) values(?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement ps = c1.c.prepareStatement(q1);

                ps.setString(1, formno);
                ps.setString(2, religion);
                ps.setString(3, category);
                ps.setString(4, income);
                ps.setString(5, education);
                ps.setString(6, occupation);
                ps.setString(7, pan);
                ps.setString(8, scitizen);
                ps.setString(9, eaccount);

                ps.executeUpdate();

                new SignupThree(formno).setVisible(true);
                setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    
    public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}
