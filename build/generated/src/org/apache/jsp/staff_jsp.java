package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import product.ProductDTO;
import product.ProductDAO;
import java.util.List;
import user.UserDTO;
import user.UserDAO;

public final class staff_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("     \n");
      out.write("    </head>\n");
      out.write("    <Style>\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <body>  \n");
      out.write("   \n");
      out.write("         <form class=\"logOut\" action=\"MainController\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Logout\"/>\n");
      out.write("          </form>\n");
      out.write("             ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = null;
            String noResults = (String) request.getAttribute("NO_RESULTS");

            if (request.getAttribute("LIST_PRODUCT") != null) {
                listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            } else {
                listProduct = dao.getAllProducts();
            }
        
      out.write("\n");
      out.write("        <h1>Welcome ");
      out.print( loginUser.getUserName());
      out.write("</h1>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            if (request.getAttribute("ERROR") != null) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\n");
      out.write("        </script >         \n");
      out.write("         ");

                }
         
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("        ");
  String fromPrice = request.getParameter("fromPrice");
            String toPrice = request.getParameter("toPrice");
            if (fromPrice == null) {
                fromPrice = "";
            }
            if (toPrice == null) {
                toPrice = "";
            }
        
      out.write("\n");
      out.write("        <form action=\"SearchController\" method=\"POST\">\n");
      out.write("            From Price: <input type=\"text\" name=\"fromPrice\" value=\"");
      out.print( fromPrice);
      out.write("\"/>\n");
      out.write("            To Price: <input type=\"text\" name=\"toPrice\" value=\"");
      out.print( toPrice);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" value=\"Search\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <h2>Search Results</h2>\n");
      out.write("        ");
 if (noResults != null) {
      out.write("\n");
      out.write("        <p>");
      out.print( noResults);
      out.write("</p>\n");
      out.write("        ");
 } else if (listProduct != null && !listProduct.isEmpty()) { 
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No</th>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>Brand </th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 0;
                    for (ProductDTO product : listProduct) {
                        double subtotal = product.getPrice() * product.getQuantity();
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("            <form action=\"MainController\" method=\"post\">\n");
      out.write("                <td>");
      out.print( ++count);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( product.getMobileId());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"mobileName\" value=\"");
      out.print( product.getMobileName());
      out.write("\" required=\"\"/>\n");
      out.write("                </td>\n");
      out.write("                 <td>\n");
      out.write("                    <input type=\"text\" name=\"description\" value=\"");
      out.print( product.getDescription());
      out.write("\" required=\"\" />\n");
      out.write("                </td>\n");
      out.write("                 <td>\n");
      out.write("                    <input type=\"number\" name=\"mobileBrand\" value=\"");
      out.print( product.getMobileBrand());
      out.write("\" required=\"\" />\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\"  name=\"price\" value=\"");
      out.print(  (float) product.getPrice());
      out.write("\" required=\"\" />\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"quantity\" value=\"");
      out.print( product.getQuantity());
      out.write("\" required=\"\" />\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("                <td>\n");
      out.write("                    <input type=\"hidden\" name=\"fromPrice\" value=\"");
      out.print( fromPrice);
      out.write("\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"toPrice\" value=\"");
      out.print( toPrice);
      out.write("\" />\n");
      out.write("                    <input type=\"hidden\" name=\"mobileId\" value=\"");
      out.print( product.getMobileId());
      out.write("\"/>\n");
      out.write("                    <input type=\"submit\" name=\"action\" value=\"Remove\"/>\n");
      out.write("                    <input type=\"submit\" name=\"action\" value=\"Update\"/>\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    ");
 } else { 
      out.write("\n");
      out.write("      <p>No products found.</p>\n");
      out.write("    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("    <h3>Add New Items</h3>\n");
      out.write("    <form action=\"AddController\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"fromPrice\" value=\"");
      out.print( fromPrice);
      out.write("\"/>\n");
      out.write("        <input type=\"hidden\" name=\"toPrice\" value=\"");
      out.print( toPrice);
      out.write("\" />\n");
      out.write("        MobileID: <input type=\"text\" name=\"mobileId\"><br>\n");
      out.write("        Description: <input type=\"text\" name=\"description\"><br>\n");
      out.write("        MobileName: <input type=\"text\" name=\"mobileName\"><br>\n");
      out.write("        Price: <input type=\"text\" name=\"price\"><br>\n");
      out.write("        YearOfProduct: <input type=\"text\" name=\"yearOfProduct\"><br>\n");
      out.write("        Quantity: <input type=\"text\" name=\"quantity\"><br>\n");
      out.write("        notSale: <input type=\"text\" name=\"notSale\"><br>\n");
      out.write("        <input type=\"submit\" value=\"Add More\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    ");

        String message = (String) request.getAttribute("MESSAGE");
        if (message == null) {
            message = "";
        }
    
      out.write("\n");
      out.write("    <div>\n");
      out.write("        ");
      out.print( message);
      out.write("\n");
      out.write("    </div>\n");
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
