/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterUser;

import java.sql.*;
import javax.ejb.Stateless;


/**
 *
 * @author Pranav
 */
@Stateless
public class BoardFunctions implements BoardFunctionsRemote {

    @Override
    public void addBoard(int bid, String leaderid, String bname, String company) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt=con.createStatement();
            String query="Insert into board values("+bid+",'"+leaderid+"','"+bname+"','"+company+"')";
            String query1="Insert into subscribes_to('"+leaderid+"'+101+0)";
            stmt.executeUpdate(query);
            stmt.executeUpdate(query1);
            stmt.close();
            con.close();
        
        }
        catch(Exception e)
        {
            
        }
        
    }

    
}
