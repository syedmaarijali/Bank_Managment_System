package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnum;
    Transactions(String pinnum){
        this.pinnum = pinnum;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        
        JLabel l1 = new JLabel("Please select any service:");
        l1.setFont(new Font("System",Font.BOLD,27));
        l1.setForeground(Color.WHITE);
        l1.setBounds(600,250,400,35);
        image.add(l1); 
        
        b1 = new JButton("Deposit");
        b1.setBounds(410,330,180,40);
        b1.setFont(new Font("Raleway", Font.BOLD,20));
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Fast Cash");
        b2.setBounds(410,400,180,40);
        b2.setFont(new Font("Raleway", Font.BOLD,20));
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Pin Change");
        b3.setBounds(410,470,180,40);
        b3.setFont(new Font("Raleway", Font.BOLD,20));
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Cash Withdraw");
        b4.setBounds(940,330,180,40);
        b4.setFont(new Font("Raleway", Font.BOLD,20));
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.setFocusable(false);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Mini Statement");
        b5.setBounds(940,400,180,40);
        b5.setFont(new Font("Raleway", Font.BOLD,20));
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.setFocusable(false);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Balance Inquiry");
        b6.setBounds(940,470,180,40);
        b6.setFont(new Font("Raleway", Font.BOLD,20));
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.setFocusable(false);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Exit");
        b7.setBounds(940,540,180,40);
        b7.setFont(new Font("Raleway", Font.BOLD,20));
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.setFocusable(false);
        b7.addActionListener(this);
        image.add(b7);
        
        
        setSize(1920,1080);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setTitle("ATM");
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b7){
            System.exit(0);
        }else if(ae.getSource() == b1){
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }else if(ae.getSource()== b2){
            setVisible(false);
            new FastCash(pinnum).setVisible(true);
        }else if(ae.getSource() == b3){
            setVisible(false);
            new PinChange(pinnum).setVisible(true);
        }else if(ae.getSource() == b4){
            setVisible(false);
            new Withdraw(pinnum).setVisible(true);
        }else if(ae.getSource() == b5){
            setVisible(false);
            new MiniStatment(pinnum,this);
        }else if (ae.getSource() == b6){
            setVisible(false);
            new BalanceEnquiry(pinnum).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
  

