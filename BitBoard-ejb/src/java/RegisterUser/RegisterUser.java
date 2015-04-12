/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterUser;

import javax.ejb.Stateless;
import java.sql.*;



/**
 *
 * @author Pranav
 */
@Stateless
public class RegisterUser implements RegisterUserRemote {
     
    @Override
    @SuppressWarnings({"UseSpecificCatch", "ConvertToTryWithResources"})
    public void addUser(String user, String pass, String email, String fname, String lname, String comp, String dept, String phno) {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            //String sql="inser11t into user values('"+user+"','"+pass+"','"+email+"','"+fname+"','"+lname+"','"+dept+"','"+phno+"','"+addr+"','"+bdate+"')";
           String test="insert into user values('"+user+"','"+pass+"','"+email+"','"+fname+"','"+lname+"','"+comp+"','"+dept+"','"+phno+"')";
           Statement stmt=con.createStatement();
           stmt.executeUpdate(test);
           stmt.close();
           con.close();
            
        }
           
        catch (Exception e) {
            System.out.println(e.toString());
           
        }
        
        
    }
    
    
  
    
}
