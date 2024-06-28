package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import user.UserDTO;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <title>TinStore</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"format-detection\" content=\"telephone=no\">\n");
      out.write("        <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <meta name=\"keywords\" content=\"\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css\" />\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"styleUser.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!-- script\n");
      out.write("         ================================================== -->\n");
      out.write("        <script src=\"js/modernizr.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("        \n");
      out.write("             ");

                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (loginUser == null || !loginUser.getRole().equals("MA")) {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    String search = request.getParameter("search");
                    if (search == null) {
                        search = "";
                    }
                
      out.write("\n");
      out.write("  <header id=\"header\" class=\"site-header header-scrolled position-fixed text-black bg-light\">\n");
      out.write("        <nav id=\"header-nav\" class=\"navbar navbar-expand-lg px-3 mb-3\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"user.jsp\">\n");
      out.write("                    <h1>  TinStore</h1>\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler d-flex d-lg-none order-3 p-2\" type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#bdNavbar\" aria-controls=\"bdNavbar\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <svg class=\"navbar-icon\">\n");
      out.write("                    <use xlink:href=\"#navbar-icon\"></use>\n");
      out.write("                    </svg>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"offcanvas offcanvas-end\" tabindex=\"-1\" id=\"bdNavbar\" aria-labelledby=\"bdNavbarOffcanvasLabel\">\n");
      out.write("                    <div class=\"offcanvas-header px-4 pb-0\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"home.html\">\n");
      out.write("                            <img src=\"image/main-logo.png\" class=\"logo\">\n");
      out.write("                        </a>\n");
      out.write("                        <button type=\"button\" class=\"btn-close btn-close-black\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\" data-bs-target=\"#bdNavbar\"></button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"offcanvas-body\">\n");
      out.write("                        <ul id=\"navbar\" class=\"navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <div style=\"margin-top:1.5rem\" class=\"user-items ps-5\">\n");
      out.write("                                    <ul class=\"d-flex justify-content-end list-unstyled\">\n");
      out.write("                                        <a href=\"invoice.jsp\">Manage Invoice</a>\n");
      out.write("                                        <li class=\"search-item pe-3\">\n");
      out.write("                                            <a href=\"home.jsp\" class=\"search-button\">\n");
      out.write("                                                <div>\n");
      out.write("                                                    <form action=\"MainController\" method=\"post\">\n");
      out.write("                                                        <button style=\"border:none\" name=\"action\" value=\"Logout\">Log Out</button>\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"pe-3\">\n");
      out.write("                                            <a href=\"#\">\n");
      out.write("                                                <p style=\"color:#212529\">");
      out.print( loginUser.getUserName());
      out.write("<p>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"cart.jsp\">\n");
      out.write("                                                <svg class=\"cart\">\n");
      out.write("                                                <use xlink:href=\"#cart\"></use>\n");
      out.write("                                                </svg>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("                <form class=\"search\" action=\"MainController\">\n");
      out.write("                    <div >\n");
      out.write("                        <input style=\"width:300px\" type=\"text\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"SearchUser\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                ");

                    List<UserDTO> listUser = (List) request.getAttribute("LIST_USER");
                    if (listUser != null) {
                        if (listUser.size() > 0) {
                
      out.write("\n");
      out.write("                <table >\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th class=\"header\">No</th>\n");
      out.write("                            <th class=\"header\">User ID</th>\n");
      out.write("                            <th class=\"header\">Full Name</th>\n");
      out.write("                            <th class=\"header\">Role ID</th>\n");
      out.write("                            <th class=\"header\">Mail</th>\n");
      out.write("                            <th class=\"header\">Phone Number</th>\n");
      out.write("                            <th class=\"header\">Password</th>\n");
      out.write("                            <th class=\"header\">Delete</th>\n");
      out.write("                            <th class=\"header\">Update</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            int count = 1;
                            for (UserDTO user : listUser) {

                        
      out.write("\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td > <input type=\"text\" name=\"No\" value=\"");
      out.print( count++);
      out.write("\" readonly=\"\"/> </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"userId\" value=\"");
      out.print( user.getUserID());
      out.write("\" readonly=\"\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"userName\" value=\"");
      out.print( user.getUserName());
      out.write("\" required=\"\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"role\"  value=\"");
      out.print( user.getRole());
      out.write("\" required=\"\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"mail\"  value=\"");
      out.print( user.getMail());
      out.write("\" required=\"\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"phone\"  value=\"");
      out.print( user.getPhone());
      out.write("\" required=\"\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td> <input styletype=\"text\" name=\"password\" value\"");
      out.print( user.getPassword());
      out.write("\" readonly=\"\" /> </td>\n");
      out.write("                            <!--detele o day ne-->\n");
      out.write("                            <td>\n");
      out.write("                                <a href=\"MainController?userID=");
      out.print( user.getUserID());
      out.write("&action=Delete&search=");
      out.print( search);
      out.write("\">Delete</a>\n");
      out.write("                            </td>\n");
      out.write("                            <!--update i day ne-->  \n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"submit\" name=\"actionUser\" value=\"Update\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("                    \n");
      out.write("                    \n");

    String error = (String) request.getAttribute("ERROR");
    if (error == null) {
        error = "";
    }

      out.write('\n');
      out.print( error);
      out.write("\n");
      out.write("\n");
      out.write("\n");

        }
    }

    String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }

      out.write('\n');
      out.print( message);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
