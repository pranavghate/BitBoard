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
public class PostFunctions implements PostFunctionsRemote {
    
    @Override
    public void addPost(String posttitle, String postcont, String bgcolor, String textcolor) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");
            String prereq="Select max(pid) from post";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(prereq);
            int newpid=rs.getInt("postid");
            //String add1="Insert into posts values('"+newpid+"','"+bid+"','"+postcont+"','"+posttitle+"')";
            String add2="Insert into post_pref values('"+newpid+"','"+textcolor+"','"+bgcolor+"')";
            //stmt.executeUpdate(add1);
            stmt.executeUpdate(add2);
            
        }
        catch(Exception e)
        {
        }
     }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String[] getPosts(String welp) {
        String[] posts=new String[10];
        int i=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");            
            Statement stmt=con.createStatement();
            String sql="Select content from posts where bid in(select bid from board where bname='"+welp+"')";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                posts[i]=rs.getString(1);
                i++;
            }
            
        }
        catch(Exception e)
        {
            
        }
        return posts;
    }
    
    public String[] getTitles(String welp) {
        String[] posts=new String[10];
        int i=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");            
            Statement stmt=con.createStatement();
            String sql="Select title from posts where bid in(select bid from board where bname='"+welp+"')";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                posts[i]=rs.getString(1);
                i++;
            }
            
        }
        catch(Exception e)
        {
            
        }
        return posts;
    }
    
    @Override
    public int checkForPosts(String welp) {
       int rowCount=0;
        try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitboard?zeroDateTimeBehavior=convertToNull", "root", "");            
            Statement stmt=con.createStatement();
            String sql="Select count(*) from posts where bid in(select bid from board where bname='"+welp+"')";
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
