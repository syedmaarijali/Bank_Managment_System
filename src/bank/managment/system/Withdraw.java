package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    String pinnum;

    Withdraw(String pinnum) {
        this.pinnum = pinnum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1080);
        add(image);
        
        JLabel l3 = new JLabel("Maximum Withdrawal Limit: Rs. 50,000");
        l3.setBounds(540, 200, 500, 30);
        l3.setFont(new Font("System", Font.BOLD, 24));
        l3.setForeground(Color.WHITE);
        image.add(l3);        

        JLabel l1 = new JLabel("Enter the amount:");
        l1.setBounds(660, 260, 400, 35);
        l1.setFont(new Font("System", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        image.add(l1);

        t1 = new JTextField();
        t1.setBounds(620, 300, 280, 32);
        t1.setFont(new Font("Raleway", Font.BOLD, 16));
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.WHITE);
        image.add(t1);

        b1 = new JButton("Withdraw");
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Raleway", Font.BOLD, 20));
        b1.setFocusable(false);
        b1.setBounds(940, 470, 180, 40);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Raleway", Font.BOLD, 20));
        b2.setFocusable(false);
        b2.setBounds(940, 540, 180, 40);
        b2.addActionListener(this);
        image.add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String amount = t1.getText().trim();

            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
                return;
            }

            try {

                int withdrawAmount = Integer.parseInt(amount);

                if (withdrawAmount <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Amount must be greater than 0");
                    return;
                }

                if (withdrawAmount > 50000) {
                    JOptionPane.showMessageDialog(null,
                            "Maximum withdrawal amount exceeded");
                    return;
                }

                Conn conn = new Conn();

                // Calculate current balance
                int balance = 0;

                Statement stmt = conn.c.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnum + "'");

                while (rs.next()) {

                    int amt = Integer.parseInt(rs.getString("amount"));

                    if (rs.getString("type").equals("Deposit")) {
                        balance += amt;
                    } else if (rs.getString("type").equals("Withdrawal")) {
                        balance -= amt;
                    }
                }

                // Check sufficient balance
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Insufficient Balance!\nAvailable Balance: Rs. " + balance);
                    return;
                }

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                String query = "INSERT INTO bank(pin,date,type,amount) VALUES(?,?,?,?)";

                PreparedStatement p = conn.c.prepareStatement(query);

                p.setString(1, pinnum);
                p.setDate(2, date);
                p.setString(3, "Withdrawal");
                p.setString(4, amount);

                p.executeUpdate();

                JOptionPane.showMessageDialog(
                        null,
                        "Rs. " + amount + " Withdrawn Successfully");

                setVisible(false);
                new Transactions(pinnum).setVisible(true);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a valid numeric amount");

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (ae.getSource() == b2) {

            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}