package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import product.ProductDAO;
import java.util.List;
import product.ProductDTO;
import user.UserDTO;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Page</title>\n");
      out.write("        <script>\n");
      out.write("            function showSuccessMessage() {\n");
      out.write("                alert(\"Book added successfully to cart\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("\n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = null;
            if (request.getAttribute("LIST_PRODUCT") != null) {
                listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            } else {
                listProduct = dao.getAllProducts();
            }
        
      out.write("\n");
      out.write("        <h1>Welcome: ");
      out.print( loginUser.getUserName());
      out.write("</h1>\n");
      out.write("        <div>\n");
      out.write("            <form action=\"MainController\" method=\"post\">\n");
      out.write("                <button name=\"action\" value=\"Logout\">Log Out</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("       \n");
      out.write("        <section class=\"py-5\">\n");
      out.write("             <div>\n");
      out.write("            <form action=\"MainController\" method=\"POST\">\n");
      out.write("                <legend>Categories</legend>\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"checkbox\" id=\"C\" name=\"C\" value=\"C\"/>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"text\" name=\"min\" name=\"fromPrice\" placeholder=\"Min Price\" />\n");
      out.write("                    <input type=\"text\" name=\"max\" name=\"toPrice\"placeholder=\"Max Price\" />\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <button type=\"submit\" name=\"action\" value=\"SEARCH\">SEARCH</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"container px-4 px-lg-5 mt-5\">\n");
      out.write("                <div class=\"row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center\">\n");
      out.write("                    ");
  for (ProductDTO product : listProduct) {
                    
      out.write("\n");
      out.write("                    <div class=\"col mb-5\">\n");
      out.write("                        <div class=\"card h-100\">\n");
      out.write("                            <!-- Product image-->\n");
      out.write("                            <img style=\"width:100%; height:250px\"class=\"card-img-top\" src=\"image/");
      out.print( product.getImage());
      out.write("\" alt=\"...\">\n");
      out.write("                            <!-- Product details-->\n");
      out.write("                            <div class=\"card-body p-4\">\n");
      out.write("                                <div class=\"text-center\">\n");
      out.write("                                    <!-- Product name-->\n");
      out.write("                                    <h5 class=\"fw-bolder\">");
      out.print( product.getMobileName());
      out.write("</h5>\n");
      out.write("                                    <!-- Product price-->\n");
      out.write("                                    ");
  if (product.getPrice() != product.newPrice()) {
                                    
      out.write("\n");
      out.write("                                    <div>\n");
      out.write("                                        <span class=\"old-price\">$");
      out.print(product.getPrice()     );
      out.write("</span>\n");
      out.write("                                        <span class=\"new-price\">         $");
      out.print(product.newPrice());
      out.write("</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    ");
 } else {
                                    
      out.write(" <span>$");
      out.print(product.getPrice());
      out.write("</span>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                    <div class=\"d-flex justify-content-center small text-warning mb-2\">\n");
      out.write("                                        <div class=\"bi-star-fill\"></div>\n");
      out.write("                                        <div class=\"bi-star-fill\"></div>\n");
      out.write("                                        <div class=\"bi-star-fill\"></div>\n");
      out.write("                                        <div class=\"bi-star-fill\"></div>\n");
      out.write("                                        <div class=\"bi-star-fill\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Product actions-->\n");
      out.write("                            <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n");
      out.write("                                <div class=\"text-center\"><a class=\"btn btn-outline-dark mt-auto\" href=\"#\">Add to cart</a></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("              </div>\n");
      out.write("            ");

                String successMessage = (String) request.getAttribute("SUCCESS");
                String errorMessage = (String) request.getAttribute("ERROR");
                if (successMessage != null) {
            
      out.write("\n");
      out.write("                <div style=\"color: red; text-align: center; margin-top: 20px;\">\n");
      out.write("                    ");
      out.print( successMessage );
      out.write("\n");
      out.write("                </div>\n");
      out.write("            ");

                }
                if (errorMessage != null) {
            
      out.write("\n");
      out.write("                <div style=\"color: red; text-align: center; margin-top: 20px;\">\n");
      out.write("                    ");
      out.print( errorMessage );
      out.write("\n");
      out.write("                </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        <div>     \n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("    </body> \n");
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
