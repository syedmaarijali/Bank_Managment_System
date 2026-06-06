package bank.managment.system;
import java.sql.*;

public class Conn {
    Connection c;
    Conn(){
     try{   // First step: creating connection done
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "jkuk");
     }
     catch (Exception e){
         System.out.println(e);
     }
    }
}
/* 1st step import all classes 
2nd try catch
3rd Connection c = DriverManager.getConnection("url","username","password")
Statment s = c.createStatment();
4th in catch (Exception e){
sout(e)
*/
