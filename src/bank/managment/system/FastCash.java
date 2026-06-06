package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnum;
    FastCash(String pinnum){
        this.pinnum = pinnum;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
        
        JLabel l1 = new JLabel("Select Withdrawal Amount:");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(490,180,400,35);
        image.add(l1);
        
        t1 = new JTextField("");
        t1.setBounds(460,220,320,25);
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        image.add(t1);
        
        b1 = new JButton("Rs. 100");
        b1.setBounds(410,269,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs. 500");
        b2.setBounds(410,315,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs. 1000");
        b3.setBounds(410,365,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs. 2000");
        b4.setBounds(700,269,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.setFocusable(false);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs. 5000");
        b5.setBounds(700,315,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.setFocusable(false);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs. 10000");
        b6.setBounds(700,365,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.setFocusable(false);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Back");
        b7.setBounds(700,416,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.setFocusable(false);
        b7.addActionListener(this);
        image.add(b7);
        
        
        setSize(1550,1080);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,0);
        //setUndecorated(true);
        setTitle("ATM");
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b7){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn conn = new Conn();
            
            try{
                String query =("select * from bank where pin = ?");

                PreparedStatement p = conn.c.prepareStatement(query);
                p.setString(1,pinnum);
                ResultSet rs =p.executeQuery();
                
                int balance = 0;
                
                while(rs.next()){ // if type is deposit then add to balance wrna agr user ne nikala hai to balance me se -. Is se total balance miljayega
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount")); // Store the balance user has and since the query will return  astring convert it to Int
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    } // Checking for sufficient balance
                }
                    if(ae.getSource() != b7 && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }else{
                        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                        String query2 = "insert into bank(pin,date,type,amount) values(?,?,?,?)";
                        PreparedStatement p2 = conn.c.prepareStatement(query2);

                        p2.setString(1, pinnum);
                        p2.setDate(2, date);
                        p2.setString(3, "Withdrawal");
                        p2.setString(4, amount);

                        p2.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Rs. " + amount+ " Debited Successfully");
                        
                        setVisible(false);
                        new Transactions(pinnum).setVisible(true);
                    }
                
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
  

