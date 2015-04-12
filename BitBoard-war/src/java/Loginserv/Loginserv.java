/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loginserv;


import RegisterUser.UserLoginRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pranav
 */
public class Loginserv extends HttpServlet {
    UserLoginRemote userLogin = lookupUserLoginRemote1();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            String username=request.getParameter("Login");
            session.setAttribute("theuser",username);
            userLogin.userLog(username);
            
                if(userLogin.checkUser(username)==1)
                {
                    out.write("<!DOCTYPE html>\r\n");
            out.write("<html lang=\"en\">\r\n");
            out.write("\r\n");
            out.write("    <head>\r\n");
            out.write("\r\n");
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
            out.write("                        <h1><a href=\"\">BitBoard <span class=\"red\">.</span></a></h1>\r\n");
            out.write("                    </div>\r\n");
            out.write("                    <div class=\"links span8\">\r\n");
            out.write("                         <a class=\"home\" href=\"index.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Home\"></a>\r\n");
            out.write("                        <a class=\"contact\" href=\"developers.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Developers\"></a>\r\n");
            out.write("                         <a class=\"about\" href=\"aboutus.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"About Us\"></a>\r\n");
            out.write("                          <a class=\"tut\" href=\"tutorial.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
            out.write("                    </div>\r\n");
            out.write("                </div>\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("\r\n");
            out.write("        <div class=\"register-container container\">\r\n");
            out.write("           <div class=\"row-fluid\">\r\n");
            out.write("           \t<div class=\"register span12\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;\"><h2 class=\"red\" align=\"center\" >Welcome,"+session.getAttribute("theuser")+"</h2></div>\r\n");
            out.write("          </div>\r\n");
            out.write("            <br>\r\n");
            out.write("            <br>\r\n");
            out.write("            <div class=\"row-fluid\">\r\n");
            
            if(userLogin.checkBoard(username)==0)
            {
                out.write("             <div class=\"register span2\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px; padding-bottom:10px;\"></div>\r\n");
                out.write("            <div class=\"register span8\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;  padding-bottom:10px;\"><h2 class=\"red\" align=\"center\">Please Select a Bulletin Board</h2>\r\n");
                out.write("            <h4 align=\"center\">or <a href=\"addboard.html\">add</a> or <a href=\"subscribe.html\">subscribe</a> to a new one.</h4><h3>It seems you havent subscribed to any bulletin boards yet.</h3></div>\r\n");     
            }
            else
            {
                //list all subscribed boards here
                String[] ret;
                ret=userLogin.getTitles(username);
                out.write("             <div class=\"register span2\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px; padding-bottom:10px;\"></div>\r\n");
                out.write("            <div class=\"register span8\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;  padding-bottom:10px;\"><h2 class=\"red\" align=\"center\">Please Select a Bulletin Board</h2>\r\n");
                out.write("            <h4 align=\"center\">or <a href=\"addboard.html\">add</a> or <a href=\"subscribe.html\">subscribe</a> to a new one.</h4>");
                for(int i=0;i<5;i++)
                {
                    if(ret[i]==null)
                    {
                        break;
                    }
                    else
                        out.write("<a href=\"disPost?name="+ret[i]+"\"><h2 align=\"center\"> "+ret[i]+"</h2></a>");
                }
                out.write("</div>\r\n");
                
            }
            out.write("            <div class=\"register span2\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;  padding-top:10px;\"></div>\r\n");
            out.write("            </div>\r\n");
            out.write("               \r\n");
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
            out.write("</html>");
                }
                else
                {
                    out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
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
      out.write("                        <h1><a href=\"\">BitBoard <span class=\"red\">.</span></a></h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"links span8\">\r\n");
      out.write("                         <a class=\"home\" href=\"index.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Home\"></a>\r\n");
      out.write("                        <a class=\"contact\" href=\"developers.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Developers\"></a>\r\n");
      out.write("                         <a class=\"about\" href=\"aboutus.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"About Us\"></a>\r\n");
      out.write("                          <a class=\"tut\" href=\"tutorial.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"register-container container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("            <div class=\"register span12\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;\"><br><br><h1 align=\"center\" class=\"red\" style=\"font-size:130px\">:(</h1><br><br><br>\r\n");
      out.write("            <h2 align=\"center\" class=\"red\">Dear "+session.getAttribute("theuser")+", Looks like you are not a part of BitBoard. But you can always join us. Please click the link below to register</h2>\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <h2 align=\"center\"><a href=\"index1.html\" >New User? Sign up</a></h2>\r\n");
      out.write("            </div>\r\n");
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

    private UserLoginRemote lookupUserLoginRemote() {
        try {
            Context c = new InitialContext();
            return (UserLoginRemote) c.lookup("java:global/BitBoard/BitBoard-ejb/UserLogin!RegisterUser.UserLoginRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UserLoginRemote lookupUserLoginRemote1() {
        try {
            Context c = new InitialContext();
            return (UserLoginRemote) c.lookup("java:global/BitBoard/BitBoard-ejb/UserLogin!RegisterUser.UserLoginRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
