/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regserv;


import RegisterUser.RegisterUserRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pranav
 */
public class regserv extends HttpServlet {
    @EJB
    private RegisterUserRemote reg;
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String user=request.getParameter("username");
            String passwd=request.getParameter("password");
            String email=request.getParameter("email");
            String fname=request.getParameter("firstname");
            String lname=request.getParameter("lastname");
            String dept=request.getParameter("department");
            String phno=request.getParameter("phonenum");
            String comp=request.getParameter("comp");
           
            
            reg.addUser(user,passwd,email,fname,lname,comp,dept,phno);
            
            
      out.write("\r\n");

    
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>:: Bulletin Board ::</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <!-- CSS -->\r\n");
      out.write("        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>\r\n");
      out.write("        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("            <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"logo span4\">\r\n");
      out.write("                        <h1><a href=\"\">Bulletin Board <span class=\"red\">.</span></a></h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"links span8\">\r\n");
      out.write("                       <a class=\"home\" href=\"\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Home\"></a>\r\n");
      out.write("                        <a class=\"blog\" href=\"\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
      out.write("                         <a class=\"about\" href=\"\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
      out.write("                          <a class=\"dev\" href=\"\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"register-container container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"phone span5\">\r\n");
      out.write("                    <img src=\"assets/img/phone.png\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"register span6\">\r\n");
      out.write("                    <form action=\"index.jsp\" method=\"post\">\r\n");
      out.write("                        <h2>REGISTER TO <span class=\"red\"><strong>Bulletin Board</strong></span></h2>\r\n");
      out.write("                        <label for=\"firstname\">First Name</label>\r\n");
      out.write("                        <input type=\"text\" id=\"firstname\" name=\"firstname\" placeholder=\"enter your first name...\">\r\n");
      out.write("                        <label for=\"lastname\">Last Name</label>\r\n");
      out.write("                        <input type=\"text\" id=\"lastname\" name=\"lastname\" placeholder=\"enter your first name...\">\r\n");
      out.write("                        <label for=\"Department\">Department</label>\r\n");
      out.write("                        <input type=\"text\" id=\"department\" name=\"department\" placeholder=\"enter your department...\">\r\n");
      out.write("                        <label for=\"Department\">Phone Number</label>\r\n");
      out.write("                        <input type=\"phone\" id=\"phonenum\" name=\"phonenum\" >\r\n");
      out.write("                        <label for=\"Date\">Date</label>\r\n");
      out.write("                        <input type=\"date\" id=\"bdate\" name=\"bdate\" >\r\n");
      out.write("                        <label for=\"username\">Username</label>\r\n");
      out.write("                        <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"choose a username...\">\r\n");
      out.write("                        <label for=\"email\">Email</label>\r\n");
      out.write("                        <input type=\"text\" id=\"email\" name=\"email\" placeholder=\"enter your email...\">\r\n");
      out.write("                        <label for=\"password\">Password</label>\r\n");
      out.write("                        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"choose a password...\">\r\n");
      out.write("                        <label for=\"address\">Address</label>\r\n");
      out.write("                        <textarea  id=\"address\" name=\"address\" placeholder=\"enter an address.\"></textarea>\r\n");
      out.write("                        \r\n");
      out.write("                        <button type=\"submit\">REGISTER</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Javascript -->\r\n");
      out.write("        <script src=\"assets/js/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.backstretch.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/scripts.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
        }
        catch(Exception e)
        {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
