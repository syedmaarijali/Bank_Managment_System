package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField t1,t2;
    JButton b1,b2;
    String pinnum;
    
    PinChange(String pinnum){
        this.pinnum = pinnum;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        
        JLabel l1 = new JLabel("Change your PIN");
        l1.setFont(new Font("System",Font.BOLD,26));
        l1.setForeground(Color.WHITE);
        l1.setBounds(680,220,400,35);
        image.add(l1);     
        
        JLabel l2 = new JLabel("Enter new PIN");
        l2.setFont(new Font("System",Font.BOLD,22));
        l2.setForeground(Color.WHITE);
        l2.setBounds(550,320,400,35);
        image.add(l2);   
        
        t1 = new JPasswordField("");
        t1.setBounds(800,320,180,30);
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        image.add(t1);        

        JLabel l3 = new JLabel("Re-Enter PIN");
        l3.setFont(new Font("System",Font.BOLD,22));
        l3.setForeground(Color.WHITE);
        l3.setBounds(550,370,400,35);
        image.add(l3);   

        t2 = new JPasswordField("");
        t2.setBounds(800,370,180,30);
        t2.setFont(new Font("Raleway",Font.BOLD,22));
        t2.setBackground(new Color(65,125,128));
        t2.setForeground(Color.WHITE);
        image.add(t2);     
        
        b1 = new JButton("Confirm");
        b1.setBounds(940,470,180,40);
        b1.setFont(new Font("Raleway", Font.BOLD,20));
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(940,540,180,40);
        b2.setFont(new Font("Raleway", Font.BOLD,20));
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        image.add(b2);        
        
        setSize(1920,1080);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setTitle("ATM");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
            
        try{
            String npin =new String(t1.getPassword());
            String rpin =new String(t2.getPassword());
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }
            if(npin.length() != 4){
                JOptionPane.showMessageDialog(null, "PIN must be 4 digits");
                return;
            }
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PINS do not match!");
                return;
            }            
            if (!npin.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                return;
            }
            
            Conn conn = new Conn();
            
            
            String query1 = "update bank set pin = ? where pin = ?";
            String query2 = "update login set pin = ? where pin = ?";
            String query3 = "update signupthree set pin = ? where pin = ?";
            
            PreparedStatement p = conn.c.prepareStatement(query1);        
            p.setString(1, rpin);
            p.setString(2, pinnum);
            p.executeUpdate();
            
            
            PreparedStatement p2 = conn.c.prepareStatement(query2);        
            p2.setString(1, rpin);
            p2.setString(2, pinnum);
            p2.executeUpdate();
            
            PreparedStatement p3 = conn.c.prepareStatement(query3);        
            p3.setString(1, rpin);
            p3.setString(2, pinnum);
            p3.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "PIN change Successfull");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        } else {
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
    }
        
    
    public static void main(String[] args){
        new PinChange("");
    }
    
}
