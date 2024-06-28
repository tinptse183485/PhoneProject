package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <!--Stylesheet-->\n");
      out.write("        <style media=\"screen\">\n");
      out.write("            *,\n");
      out.write("            *:before,\n");
      out.write("            *:after{\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background-color: #080710;\n");
      out.write("            }\n");
      out.write("            .background{\n");
      out.write("                width: 430px;\n");
      out.write("                height: 520px;\n");
      out.write("                position: absolute;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("                left: 50%;\n");
      out.write("                top: 50%;\n");
      out.write("            }\n");
      out.write("            .background .shape{\n");
      out.write("                height: 200px;\n");
      out.write("                width: 200px;\n");
      out.write("                position: absolute;\n");
      out.write("                border-radius: 50%;\n");
      out.write("            }\n");
      out.write("            .shape:first-child{\n");
      out.write("                background: linear-gradient(\n");
      out.write("                    #1845ad,\n");
      out.write("                    #23a2f6\n");
      out.write("                    );\n");
      out.write("                left: -80px;\n");
      out.write("                top: -80px;\n");
      out.write("            }\n");
      out.write("            .shape:last-child{\n");
      out.write("                background: linear-gradient(\n");
      out.write("                    to right,\n");
      out.write("                    #ff512f,\n");
      out.write("                    #f09819\n");
      out.write("                    );\n");
      out.write("                right: -30px;\n");
      out.write("                bottom: -80px;\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                height: 520px;\n");
      out.write("                width: 400px;\n");
      out.write("                background-color: rgba(255,255,255,0.13);\n");
      out.write("                position: absolute;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                backdrop-filter: blur(10px);\n");
      out.write("                border: 2px solid rgba(255,255,255,0.1);\n");
      out.write("                box-shadow: 0 0 40px rgba(8,7,16,0.6);\n");
      out.write("                padding: 50px 35px;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                font-size: 45px;\n");
      out.write("                font-weight: inherit;\n");
      out.write("                font-size-adjust: 40px;\n");
      out.write("            }\n");
      out.write("            form *{\n");
      out.write("                font-family: 'Poppins',sans-serif;\n");
      out.write("                color: #ffffff;\n");
      out.write("                letter-spacing: 0.5px;\n");
      out.write("                outline: none;\n");
      out.write("                border: none;\n");
      out.write("            }\n");
      out.write("            form h3{\n");
      out.write("                font-size: 40px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                line-height: 42px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            label{\n");
      out.write("                display: block;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: 500;\n");
      out.write("            }\n");
      out.write("            form input{\n");
      out.write("                display: block;\n");
      out.write("                height: 50px;\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: rgba(255,255,255,0.07);\n");
      out.write("                border-radius: 3px;\n");
      out.write("                padding: 0 10px;\n");
      out.write("                margin-top: 8px;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-weight: 300;\n");
      out.write("            }\n");
      out.write("            ::placeholder{\n");
      out.write("                color: #e5e5e5;\n");
      out.write("            }\n");
      out.write("            button {\n");
      out.write("                margin-top: 20px;\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: #ffffff;\n");
      out.write("                color: #080710;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            button.login {\n");
      out.write("                color: #080710;\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: 600;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .social{\n");
      out.write("                margin-top: 30px;\n");
      out.write("                display: flex;\n");
      out.write("            }\n");
      out.write("            .social div{\n");
      out.write("                background: red;\n");
      out.write("                width: 150px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                padding: 5px 10px 10px 5px;\n");
      out.write("                background-color: rgba(255,255,255,0.27);\n");
      out.write("                color: #eaf0fb;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .social div:hover{\n");
      out.write("                background-color: rgba(255,255,255,0.47);\n");
      out.write("            }\n");
      out.write("            .social .fb{\n");
      out.write("                margin-left: 25px;\n");
      out.write("            }\n");
      out.write("            .social i{\n");
      out.write("                margin-right: 4px;\n");
      out.write("            }\n");
      out.write("            form .links{\n");
      out.write("                padding-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"background\">\n");
      out.write("            <div class=\"shape\"></div>\n");
      out.write("            <div class=\"shape\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"post\">\n");
      out.write("            <h1> Login </h1>\n");
      out.write("            <label for=\"username\">Username</label>\n");
      out.write("            <input type=\"text\" required name=\"user\"/>\n");
      out.write("            <label for=\"password\">Password</label>\n");
      out.write("            <input type=\"password\" required name=\"pass\"/>   \n");
      out.write("            ");

                String error = (String) request.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            
      out.write("\n");
      out.write("             ");

                String message = (String) request.getAttribute("MESSAGE");
                if (message == null) {
                    message = "";
                }
            
      out.write("\n");
      out.write("            <h4 style=\" color:red \">");
      out.print( error);
      out.write("</h4>\n");
      out.write("            <h4 style=\" color:white \">");
      out.print( message);
      out.write("</h4>\n");
      out.write("\n");
      out.write("            <div class=\"links\">\n");
      out.write("                <a  href=\"create.jsp\">Create new account</a></br>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" name=\"action\" value=\"Login\">\n");
      out.write("                Login\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
