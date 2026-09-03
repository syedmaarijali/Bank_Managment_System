package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton clear,signup,login;
    JTextField cardtext;
    JPasswordField pintext;
    Login(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //load image into ImageIcon 
                //Extract image from IconImage    //scale the image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        //We cant place Image directly into JLabel so we convert it back to ImageIcon
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label2 = new JLabel(i3);
        label2.setBounds(70,10,100,100);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,130,40);
        cardtext = new JTextField();
        cardtext.setBounds(300,150,250,40);
        cardtext.setFont(new Font("Arial",Font.BOLD,14 ));
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,130,40);  
        pintext = new JPasswordField();
        pintext.setBounds(300,220,250,40);
        pintext.setFont(new Font("Arial",Font.BOLD,14 ));
        
        login = new JButton("Sign In");
        login.setBounds(300,270,90,40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFocusable(false);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,270,90,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setFocusable(false);
        clear.addActionListener(this);
        
        signup = new JButton("Sign Up");
        signup.setBounds(370,320,90,40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setFocusable(false);
        signup.addActionListener(this);
        
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM");
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
       
        add(label2);
        add(text);
        add(cardno);
        add(cardtext);
        add(pin);
        add(pintext);
        add(login);
        add(clear);
        add(signup);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){ // this method defines what to do when action is performed
        if(ae.getSource() == clear){
            cardtext.setText("");
            pintext.setText("");
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnum =cardtext.getText();
            String pinnum = new String(pintext.getPassword());
            try{
            String query ="select * from login where cardnumber = ? and pin = ?";
            
            PreparedStatement p = conn.c.prepareStatement(query);
            p.setString(1, cardnum);
            p.setString(2, pinnum);          
                
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Information");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}
