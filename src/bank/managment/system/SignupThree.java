package bank.managment.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton savingR,recurringR,currentR,fixedDepR;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel l2 = new JLabel("Account Type");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(100,140,200,30);
        add(l2);
        
        savingR = new JRadioButton("Saving Account");
        savingR.setFont(new Font ("Raleway",Font.BOLD,16));
        savingR.setBackground(Color.WHITE);
        savingR.setBounds(100,180,150,20);
        add(savingR);
        
        fixedDepR = new JRadioButton("Fixed Deposit Account");
        fixedDepR.setFont(new Font ("Raleway",Font.BOLD,16));
        fixedDepR.setBackground(Color.WHITE);
        fixedDepR.setBounds(350,180,250,20);
        add(fixedDepR);
        
        currentR = new JRadioButton("Current Account");
        currentR.setFont(new Font ("Raleway",Font.BOLD,16));
        currentR.setBackground(Color.WHITE);
        currentR.setBounds(100,220,150,20);
        add(currentR);
        
        recurringR = new JRadioButton("Recurring Deposit Account");
        recurringR.setFont(new Font ("Raleway",Font.BOLD,16));
        recurringR.setBackground(Color.WHITE);
        recurringR.setBounds(350,220,250,20);
        add(recurringR);
        
        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(savingR);
        groupacc.add(fixedDepR);
        groupacc.add(currentR);
        groupacc.add(recurringR);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,40);
        add(card);
        
        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cnumber.setBounds(330,300,300,40);
        add(cnumber);
        
        JLabel cDetail = new JLabel("Your 16 digit card number");
        cDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cDetail.setBounds(100,330,300,20);
        add(cDetail);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,40);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,40);
        add(pnumber);
        
        JLabel pDetail = new JLabel("Your 4 digit pin:");
        pDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pDetail.setBounds(100,400,300,20);
        add(pDetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,400,40);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font(":Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that all above entered details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setFocusable(false);
        submit.setBounds(250,720,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setFocusable(false);
        cancel.setBounds(420,720,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if (savingR.isSelected()){
                accountType = "Saving Account";
            }else if(fixedDepR.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(currentR.isSelected()){
                accountType = "Current Account";
            }else if(recurringR.isSelected()){
                accountType = "Recurring Account";
            }
            if(!c7.isSelected()){
    JOptionPane.showMessageDialog(null, "Please accept the declaration");
    return;
}
            Random rca = new Random();
        long first7 = (rca.nextLong() % 90000000L) + 5040936000000000L;
        String cardnumber = "" + Math.abs(first7);
        
 // %04d means fill empty spaces on left with 0 with width being 4
        String pin =String.format("%04d",rca.nextInt(9999)+1); // (10000) ! because it can produce 0000 but if we +1 it will prevent 0000
            
            String facility ="";

            if (c1.isSelected()) {
                facility += " ATM Card";
            }
            if (c2.isSelected()) {
                facility += " Internet Banking";
            }
            if (c3.isSelected()) {
                facility += " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility += " Email & SMS Alerts";
            }
            if (c5.isSelected()) {
                facility += " Cheque Book";
            }
            if (c6.isSelected()) {
                facility += " E-Statement";
            }
            
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                    return;
                }
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree (formno, accountType, cardnumber, pin, facility) values (?,?,?,?,?)";
                    String query2 = "insert into login ( formno, cardnumber, pin) values (?,?,?)";

                    
                    PreparedStatement p1 = conn.c.prepareStatement(query1);
                    p1.setString(1, formno);
                    p1.setString(2, accountType);
                    p1.setString(3, cardnumber);
                    p1.setString(4, pin);
                    p1.setString(5, facility);
                    p1.executeUpdate();
                    
                    PreparedStatement p2 = conn.c.prepareStatement(query2);
                    p2.setString(1,formno);
                    p2.setString(2,cardnumber);
                    p2.setString(3,pin);
                    p2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Card Number " + cardnumber+ "\n PIN "+ pin);
                    
                    setVisible(false);
                    new Deposit(pin).setVisible(true);

            } catch (Exception e){
              System.out.println(e);
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new SignupThree("");
    }
    
}
