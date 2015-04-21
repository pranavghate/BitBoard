/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bugserv;

import RegisterUser.BugReportRemote;
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
public class Bugserv extends HttpServlet {
    @EJB
    private BugReportRemote bugReport;
    
    

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
            String title=request.getParameter("bugtitle");
            String content=request.getParameter("bugcon");
            bugReport.report(601,title,content);
            /* TODO output your page here. You may use following sample code. */
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
      out.write("                          <a class=\"home\" href=\"index.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Home\"></a>\r\n");
      out.write("                        <a class=\"contact\" href=\"developers.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Developers\"></a>\r\n");
      out.write("                         <a class=\"about\" href=\"aboutus.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"About Us\"></a>\r\n");
      out.write("                          <a class=\"tut\" href=\"tutorial.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Tutorial\"></a>\r\n");
      out.write("                          <a class=\"bug\" href=\"bugreport.html\" rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"Bug Reporting\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"register-container container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("            \t<div class=\"register span12\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px;\">\r\n");
      out.write("                <h2 class=\"red\" align=\"center\">Report a Bug</h2>\r\n");
       out.write("                <h2 class=\"red\" align=\"center\">Bug Reported</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("            \t<div class=\"register span12\" style=\"background-color:#F2F2F2; border-radius:5px; box-shadow: 0px 0px 2px 1px #888888;text-shadow: 0px 0px 1px; height:10px\">\r\n");
      out.write("                <form action=\"Bugserv\" method=\"post\">\r\n");
      out.write("                <label for=\"Title\">Give a Title</label>\r\n");
      out.write("                        <input type=\"text\" id=\"bugtitle\" name=\"bugtitle\" placeholder=\"Enter a title\">\r\n");
      out.write("                        <label for=\"Content\">Give an explanation</label>\r\n");
      out.write("                        <textarea id=\"bugcon\" name=\"bugcon\" placeholder=\"Please elaborate the bug.\"></textarea><br>\r\n");
      out.write("                       <button type=\"submit\">Report Bug</button>\r\n");
      out.write("                        </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
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
