package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnum;
    BalanceEnquiry(String pinnum){
        this.pinnum = pinnum;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        back = new JButton("Back");
        back.setBounds(705,410,150,35);
        back.setBackground(new Color(65,125,128));
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        image.add(back);   
        
        Conn c = new Conn();
        int balance = 0;   
        try {
            PreparedStatement ps = c.c.prepareStatement("SELECT * FROM bank WHERE pin = ?");
            ps.setString(1, pinnum);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) { // if type is deposit then add to balance wrna agr user ne nikala hai to balance me se -. Is se total balance miljayega
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount")); // Store the balance user has and since the query will return  astring convert it to Int
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                } // Checking for sufficient balance
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel l1 = new JLabel("Your current Balance is:");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setBounds(510,176,400,35);
        image.add(l1);
        
        JLabel l2 = new JLabel("" +balance);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,22));
        l2.setBounds(620,222,400,35);
        image.add(l2);
        
        
        setSize(1550,1080);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,0);
        //setUndecorated(true);
        setTitle("ATM");
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnum).setVisible(true);
        
    
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
