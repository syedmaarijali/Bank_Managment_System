package bank.managment.system;
import java.sql.*;

public class Conn {
    Connection c;
    Conn(){
     try{   
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "jkuk");
     }
     catch (Exception e){
         System.out.println(e);
     }
    }
}

