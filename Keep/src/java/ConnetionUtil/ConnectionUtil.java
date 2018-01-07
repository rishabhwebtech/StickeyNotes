/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnetionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Rishabh
 */
public class ConnectionUtil {
  public  static Connection getConnection(){
        Connection conn=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/note","root","admin");
        }
        catch(ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND");
        }
        catch(SQLException e){
         System.out.println("CLASS NOT FOUND");
    }
        return conn;
    }
}
