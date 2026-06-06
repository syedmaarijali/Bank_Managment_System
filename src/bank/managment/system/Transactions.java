package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnum;
    Transactions(String pinnum){
        this.pinnum = pinnum;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
        
        JLabel l1 = new JLabel("Enter Amount you want to Deposit:");
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
        
        b1 = new JButton("Deposit");
        b1.setBounds(410,269,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Fast Cash");
        b2.setBounds(410,315,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Pin Change");
        b3.setBounds(410,365,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Cash Withdrawl");
        b4.setBounds(700,269,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.setFocusable(false);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Mini Statment");
        b5.setBounds(700,315,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.setFocusable(false);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Balance Inquiry");
        b6.setBounds(700,365,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.setFocusable(false);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Exit");
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
            new MiniStatment(pinnum).setVisible(true);
        }else if (ae.getSource() == b6){
            setVisible(false);
            new BalanceEnquiry(pinnum).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
  

