/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterUser;

import java.sql.*;
import javax.ejb.Stateful;

/**
 *
 * @author Pranav
 */
@Stateful
public class UserLogin implements UserLoginRemote {

    @Override
    public void userLog(String userid) {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
        Statement stmt=con.createStatement();
        String addtolog="insert into login_log values('"+userid+"',NOW());";
        stmt.executeUpdate(addtolog);
        }
        catch(Exception e)
        {
            
        }
        
        
    }

    @Override
    public int checkUser(String username) {
        int rowCount=0;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
        Statement stmt=con.createStatement();
        String query="Select COUNT(*) from user where userid= '" +username+ "'";
        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        rowCount=rs.getInt(1);
       
       
        }
        catch(Exception e)
                {
                    
                }
        
        if(rowCount==0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override

   
    public int checkBoard(String username) {
        int rowCount=0;
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt=con.createStatement();
            String sql="select count(*) from subscribes_to where username='"+username+"'";
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            rowCount=rs.getInt(1);
            
            
        }
        catch(Exception e)
        {
        }
        if(rowCount==0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public String[] getTitles(String username) {
        String[] names=new String[5];
        int i=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt=con.createStatement();
            String test="Select bname from board where bid in(select bid from subscribes_to where username='"+username+"')";
            ResultSet rs=stmt.executeQuery(test);
            while(rs.next())
            {
                names[i]=rs.getString(1);
                i++;
            }
            
        }
        catch(Exception e)
        {
            
        }
        return names;
        
    }

    @Override
    public int checkAdmin(String user) {
        
        int rowCount=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt=con.createStatement();
            String sql="select isadmin from user where userid='"+user+"'";
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            rowCount=rs.getInt(1);
        }
        catch(Exception e)
                {
                    
                }
        if(rowCount==0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    
    
}
