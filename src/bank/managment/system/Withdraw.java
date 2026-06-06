package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1, b2;
    String pinnum;
    
    Withdraw(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
        
        JLabel l1 = new JLabel("Enter the amount:");
        l1.setBounds(555,176,400,35);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        image.add(l1);
        
        t1 = new JTextField("");
        t1.setBounds(512,220,220,25);
        t1.setFont(new Font("Raleway",Font.BOLD,16));
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        image.add(t1);
        
        b1 = new JButton("Withdraw");
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.setBounds(700,365,150,35);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.setBounds(700,416,150,35);
        b2.addActionListener(this);
        image.add(b2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM");
        setSize(1550,1080);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String amount = t1.getText();

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Amount cant be 0");
            }
            else{
                try{
                    
                Conn conn = new Conn();
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                
                String query = "insert into bank(pin,date,type,amount) values(?,?,?,?)";
                PreparedStatement p =conn.c.prepareStatement(query);
                
                p.setString(1,pinnum);
                p.setDate(2,date);
                p.setString(3,"Withdrawal");
                p.setString(4, amount);
                
                p.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Rs. " +amount+ " Withdrawn succesfully");
                setVisible(false);
                new Transactions(pinnum).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    else if(ae.getSource() == b2){
        setVisible(false);
        new Transactions(pinnum).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Withdraw("");
    }
    
}
