package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatment extends JFrame{
 Conn conn = new Conn();
 int balance = 0;
    MiniStatment(String pinnum) {

        JLabel title = new JLabel("Bank of Pakistan");
title.setFont(new Font("System", Font.BOLD, 22));
title.setBounds(0, 10, 400, 30);
title.setHorizontalAlignment(SwingConstants.CENTER);
add(title);
        
        JLabel l1 = new JLabel();
        add(l1);

        try {

            // BALANCE CALCULATION
            PreparedStatement psBalance
                    = conn.c.prepareStatement("SELECT * FROM bank WHERE pin = ?");

            psBalance.setString(1, pinnum);
            ResultSet rsBalance = psBalance.executeQuery();

            while (rsBalance.next()) {

                if (rsBalance.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rsBalance.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rsBalance.getString("amount"));
                }
            }

            // BUILD UI
            StringBuilder statement = new StringBuilder("<html>");

            //statement.append("<br>");

            // CARD NUMBER
            PreparedStatement ps1 = conn.c.prepareStatement(
                    "SELECT cardnumber FROM login WHERE pin = ?"
            );
            ps1.setString(1, pinnum);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                String card = rs1.getString("cardnumber");
                statement.append("<div style='padding-left:20px;'><br>")
                        .append("Card Number: ")
                        .append(card.substring(0, 4))
                        .append("XXXXXXXX")
                        .append(card.substring(card.length() - 4))
                        .append("</div><br><br><br>");
            }

            // LAST 5 TRANSACTIONS
            PreparedStatement ps = conn.c.prepareStatement(
                    "SELECT * FROM (SELECT * FROM bank WHERE pin = ? ORDER BY id DESC LIMIT 5) t ORDER BY id ASC"
            );
            ps.setString(1, pinnum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                statement.append("<div style='padding-left:20px;'>")
                        .append(rs.getString("date"))
                        .append(" | ")
                        .append(rs.getString("type"))
                        .append(" | Rs. ")
                        .append(rs.getString("amount"))
                        .append("</div><br>");
            }

            // BALANCE
            statement.append("<hr>");
            statement.append("<div style='padding-left:20px;'><br>")
                    .append("<b>Current Balance: Rs. ")
                    .append(balance)
                    .append("</b></div>");

            statement.append("</html>");

            l1.setText(statement.toString());

        } catch (Exception e) {
            System.out.println(e);
        }

        l1.setBounds(20, 60, 350, 400);

        setSize(400, 500);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(540, 160);
        setTitle("Mini Statement");
        setVisible(true);
    }

    public static void main(String[] args){
        new MiniStatment("");
    }
}
