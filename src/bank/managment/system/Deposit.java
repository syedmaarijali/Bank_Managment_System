package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1, b2;
    String pinnum;
    
    Deposit(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        
        JLabel l1 = new JLabel("Enter the amount:");
        l1.setBounds(660,250,400,35);
        l1.setFont(new Font("System",Font.BOLD,26));
        l1.setForeground(Color.WHITE);
        image.add(l1);
        
        JLabel l3 = new JLabel("Maximum Deposit Limit: Rs. 50,000");
        l3.setBounds(570, 200, 500, 30);
        l3.setFont(new Font("System", Font.BOLD, 24));
        l3.setForeground(Color.WHITE);
        image.add(l3);        
        
        t1 = new JTextField("");
        t1.setBounds(620,300,310,32);
        t1.setFont(new Font("Raleway",Font.BOLD,16));
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        image.add(t1);
        
        b1 = new JButton("Deposit");
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Raleway", Font.BOLD,20));
        b1.setFocusable(false);
        b1.setBounds(940,470,180,40);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(940,540,180,40);
        b2.setFocusable(false);
        b2.setFont(new Font("Raleway", Font.BOLD,20));
        b2.addActionListener(this);
        image.add(b2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM");
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setUndecorated(true);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String amount = t1.getText().trim(); // gettext and trim the white spaces

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Amount cant be 0");
                return;
            }
            else{
                try{
                int depositAmount =Integer.parseInt(amount);
                
                if(depositAmount <= 0){
                    JOptionPane.showMessageDialog(null, "Amount must be greater than 0");
                    return;
                }
                if(depositAmount > 50000){
                    JOptionPane.showMessageDialog(null,"Maximum deposit amount exceded");
                    return;
                }
                
                Conn conn = new Conn();
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                
                String query = "insert into bank (pin,date,type,amount)values (?,?,?,?)";
                PreparedStatement p = conn.c.prepareStatement(query);
                
                p.setString(1, pinnum);
                p.setDate(2, date);
                p.setString(3, "Deposit");
                p.setString(4, amount);

                
                p.executeUpdate();
                JOptionPane.showMessageDialog(null, "Rs. " +amount+ " deposited succesfully");
                setVisible(false);
                new Transactions(pinnum).setVisible(true);
                } catch( NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Please enter numeric values!!");
                }
                catch (Exception e){
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
        new Deposit("");
    }
    
}
