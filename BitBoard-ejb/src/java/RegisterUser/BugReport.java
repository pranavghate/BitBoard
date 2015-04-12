/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.ejb.Stateless;

/**
 *
 * @author Pranav
 */
@Stateless
public class BugReport implements BugReportRemote {

    @Override
    public void report(int bugid, String bugname, String bugdesc) {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt=con.createStatement();
            String sql="Insert into bug_reports values("+bugid+"+'"+bugname+"'+'"+bugdesc+"')";
            stmt.executeUpdate(sql);
            con.close();
            stmt.close();
        }
        catch(Exception e)
        {
            
        }
    }

    
}
