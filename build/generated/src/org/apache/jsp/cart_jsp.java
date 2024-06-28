package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Random;
import user.UserDTO;
import cart.CartDTO;
import cart.CartDAO;
import java.util.List;
import Invoice.InvoiceDTO;
import Invoice.InvoiceDAO;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
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
      out.write("\n");
      out.write("    <link href=\"styleManager.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

        
      out.write("    \n");
      out.write("         <header id=\"header\" class=\"site-header header-scrolled position-fixed text-black bg-light\">\n");
      out.write("            <nav id=\"header-nav\" class=\"navbar navbar-expand-lg px-3 mb-3\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"user.jsp\">\n");
      out.write("                        <h1>  TinStore</h1>\n");
      out.write("                    </a>\n");
      out.write("                    <button class=\"navbar-toggler d-flex d-lg-none order-3 p-2\" type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#bdNavbar\" aria-controls=\"bdNavbar\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <svg class=\"navbar-icon\">\n");
      out.write("                        <use xlink:href=\"#navbar-icon\"></use>\n");
      out.write("                        </svg>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"offcanvas offcanvas-end\" tabindex=\"-1\" id=\"bdNavbar\" aria-labelledby=\"bdNavbarOffcanvasLabel\">\n");
      out.write("                        <div class=\"offcanvas-header px-4 pb-0\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"home.html\">\n");
      out.write("                                <img src=\"image/main-logo.png\" class=\"logo\">\n");
      out.write("                            </a>\n");
      out.write("                            <button type=\"button\" class=\"btn-close btn-close-black\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\" data-bs-target=\"#bdNavbar\"></button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"offcanvas-body\">\n");
      out.write("                            <ul id=\"navbar\" class=\"navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <div style=\"margin-top:1.5rem\" class=\"user-items ps-5\">\n");
      out.write("                                        <ul class=\"d-flex justify-content-end list-unstyled\">\n");
      out.write("                                           \n");
      out.write("\n");
      out.write("                                            <li class=\"search-item pe-3\">\n");
      out.write("                                                <a href=\"home.jsp\" class=\"search-button\">\n");
      out.write("                                                    <div>\n");
      out.write("                                                        <form action=\"MainController\" method=\"post\">\n");
      out.write("                                                            <button style=\"border:none\" name=\"action\" value=\"Logout\">Log Out</button>\n");
      out.write("                                                        </form>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"pe-3\">\n");
      out.write("                                                <a href=\"#\">\n");
      out.write("                                                    <p style=\"color:#212529\">");
      out.print( loginUser.getUserName());
      out.write("<p>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            \n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write(" <div class=\"hid\">\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("        <div class=\"site-section\">\n");
      out.write("            ");
        CartDAO cartDAO = new CartDAO();
                List<CartDTO> cartList = null;

                if (loginUser != null) {

                    String userID = loginUser.getUserID();
                    cartList = cartDAO.getCart(userID);
                    session.setAttribute("cartList", cartList);

                }

            
      out.write("      \n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row mb-5\">\n");
      out.write("                    <div class=\"col-md-12\" >\n");
      out.write("                        <div class=\"site-blocks-table\">\n");
      out.write("                            <table class=\"table table-bordered\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th class=\"product-thumbnail\">Image</th>\n");
      out.write("                                        <th class=\"product-name\">Product</th>\n");
      out.write("                                        <th class=\"product-price\">Price</th>\n");
      out.write("                                        <th class=\"product-quantity\">Quantity</th>\n");
      out.write("                                        <th class=\"product-total\">Total</th>\n");
      out.write("                                        <th class=\"product-remove\">Remove</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
 float totalCost = 0;

                                        String invId = (String) session.getAttribute("invId");
                                        
                                        if (invId == null) {
                                            invId = "INV-" + new Random().nextInt(10000);
                                            session.setAttribute("invId", invId);
                                        }
                                        if (cartList != null) { 
      out.write("\n");
      out.write("                                    ");
 for (CartDTO cart : cartList) {
                                            cart.setInvId(invId);
                                            cartDAO.updateInvId(cart);
                                            totalCost += cart.getTotalPrice();
      out.write("\n");
      out.write("                                <form class=\"col-md-12\"  action=\"MainController\" method=\"POST\">    \n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"product-thumbnail\">\n");
      out.write("                                            <img style=\"width:170px ;height: 170px\"src=\"image/");
      out.print(cart.getImage());
      out.write("\" alt=\"Image\" class=\"img-fluid\">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"product-name\">\n");
      out.write("                                            <h2 class=\"h5 text-black\">");
      out.print(cart.getMobileId());
      out.write("</h2>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>");
      out.print(cart.getPrice());
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <div class=\"input-group mb-3\" style=\"width: 100%;\">\n");
      out.write("                                                <input type=\"hidden\" name=\"cartId\" value=\"");
      out.print(cart.getCartId());
      out.write("\">\n");
      out.write("                                                <input type=\"text\" name=\"quantity\"  value=\"");
      out.print(cart.getQuantity());
      out.write("\">\n");
      out.write("\n");
      out.write("                                                <button name=\"action\" value=\"Change\" type=\"submit\" class=\"btn btn-primary btn-sm\">Update</button>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>");
      out.print(cart.getTotalPrice());
      out.write("</td>\n");
      out.write("                                        <td> \n");
      out.write("                                            <input type=\"hidden\" name=\"cartId\" value=\"");
      out.print(cart.getCartId());
      out.write("\">\n");
      out.write("                                            <button name=\"action\"value=\"RemoveCart\" class=\"btn btn-primary btn-sm\">X</button>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </form>    \n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"row mb-5\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <a href=\"user.jsp\" class=\"btn btn-outline-primary btn-sm btn-block\">Continue Shopping</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6 mb-3 mb-md-0\">\n");
      out.write("                                ");

                                    String message = (String) request.getAttribute("message");
                                    if (message == null) {
                                        message = "";
                                    }
                                
      out.write("\n");
      out.write("                                ");

                                    String error = (String) request.getAttribute("cart");
                                    if (error == null) {
                                        error = "";
                                    }
                                
      out.write("\n");
      out.write("                                <div class=\"d-flex justify-content-center\">\n");
      out.write("                                    <h3 style=\"color: greenyellow;\">");
      out.print( message);
      out.write("</h3>\n");
      out.write("                                </div>  \n");
      out.write("                                 <div class=\"d-flex justify-content-center\">\n");
      out.write("                                    <h3 style=\"color: red;\">");
      out.print( error);
      out.write("</h3>\n");
      out.write("                                </div>  \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 pl-5\">\n");
      out.write("                        <div class=\"row justify-content-end\">\n");
      out.write("                            <div class=\"col-md-7\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("\n");
      out.write("                                    <div class=\"col-md-12 text-right border-bottom mb-5\">\n");
      out.write("                                        <h3 class=\"text-black h4 text-uppercase\">Cart Totals</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row mb-5\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <span class=\"text-black\">Total</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6 text-right\">\n");
      out.write("                                        <strong class=\"text-black\">$");
      out.print(totalCost);
      out.write("</strong>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        ");

                                            InvoiceDAO dao = new InvoiceDAO();
                                            boolean invoiceExists = dao.invoiceExists(invId);
                                            if (!invoiceExists && totalCost > 0) {
                                                InvoiceDTO invoice = new InvoiceDTO();
                                                invoice.setInvId(invId);
                                                invoice.setUserID(loginUser.getUserID());
                                                invoice.setTotal(totalCost);
                                                invoice.setDateBuy("null"); // You might want to set this to the current date instead
                                                invoice.setGmail("null"); // You might want to set this to the user's actual email
                                                invoice.setAddress("null"); // You might want to set this to the user's actual address

                                                // Store the invoice in the session
                                                session.setAttribute("invoice", invoice);
                                        
      out.write("\n");
      out.write("                                        <div>\n");
      out.write("                                            <a href=\"checkout.jsp\" class=\"btn btn-primary btn-lg py-3 btn-block\">Go to Checkout</a>\n");
      out.write("                                        </div>     \n");
      out.write("                                        ");

                                            } else {

                                                request.setAttribute("message", "Cannot checkout");

                                            }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                                            <footer id=\"footer\" class=\"overflow-hidden\">\n");
      out.write("      <div style=\"margin-top:2em\"class=\"container\">\n");
      out.write("        <div class=\"row mainn\">\n");
      out.write("          <div class=\"footer-top-area\">\n");
      out.write("            <div class=\"row d-flex flex-wrap justify-content-between\">\n");
      out.write("              <div class=\"col-lg-3 col-sm-6 pb-3\">\n");
      out.write("                <div class=\"footer-menu\">\n");
      out.write("                  <h1>TinStore</h1>\n");
      out.write("                  <p>Your attentions is our happiness and motivation to develop more qualified products.</p>\n");
      out.write("                  <div class=\"social-links\">\n");
      out.write("                    <ul class=\"d-flex list-unstyled\">\n");
      out.write("                      <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                          <svg class=\"facebook\">\n");
      out.write("                            <use xlink:href=\"#facebook\" />\n");
      out.write("                          </svg>\n");
      out.write("                        </a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                          <svg class=\"instagram\">\n");
      out.write("                            <use xlink:href=\"#instagram\" />\n");
      out.write("                          </svg>\n");
      out.write("                        </a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                          <svg class=\"twitter\">\n");
      out.write("                            <use xlink:href=\"#twitter\" />\n");
      out.write("                          </svg>\n");
      out.write("                        </a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                          <svg class=\"linkedin\">\n");
      out.write("                            <use xlink:href=\"#linkedin\" />\n");
      out.write("                          </svg>\n");
      out.write("                        </a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                          <svg class=\"youtube\">\n");
      out.write("                            <use xlink:href=\"#youtube\" />\n");
      out.write("                          </svg>\n");
      out.write("                        </a>\n");
      out.write("                      </li>\n");
      out.write("                    </ul>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-2 col-sm-6 pb-3\">\n");
      out.write("                <div class=\"footer-menu text-uppercase\">\n");
      out.write("                  <h5 class=\"widget-title pb-2\">Quick Links</h5>\n");
      out.write("                  <ul class=\"menu-list list-unstyled text-uppercase\">\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">About</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Shop</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Blogs</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Contact</a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-3 col-sm-6 pb-3\">\n");
      out.write("                <div class=\"footer-menu text-uppercase\">\n");
      out.write("                  <h5 class=\"widget-title pb-2\">Help & Info Help</h5>\n");
      out.write("                  <ul class=\"menu-list list-unstyled\">\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Track Your Order</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Returns Policies</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Shipping + Delivery</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Contact Us</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"menu-item pb-2\">\n");
      out.write("                      <a href=\"#\">Faqs</a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-3 col-sm-6 pb-3\">\n");
      out.write("                <div class=\"footer-menu contact-item\">\n");
      out.write("                  <h5 class=\"widget-title text-uppercase pb-2\">Contact Us</h5>\n");
      out.write("                  <p>Do you have any queries or suggestions? <a href=\"mailto:\">tinptse183485@fpt.edu.vn</a>\n");
      out.write("                  </p>\n");
      out.write("                  <p>If you need support? Just give us a call. <a href=\"\">0899 452 877</a>\n");
      out.write("                  </p>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <hr>\n");
      out.write("    </footer>\n");
      out.write("    <div id=\"footer-bottom\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row d-flex flex-wrap justify-content-between\">\n");
      out.write("          <div class=\"col-md-4 col-sm-6\">\n");
      out.write("            <div class=\"Shipping d-flex\">\n");
      out.write("              <p>We ship with:</p>\n");
      out.write("              <div class=\"card-wrap ps-2\">\n");
      out.write("                <img src=\"image/dhl.png\" alt=\"visa\">\n");
      out.write("                <img src=\"image/shippingcard.png\" alt=\"mastercard\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-4 col-sm-6\">\n");
      out.write("            <div class=\"payment-method d-flex\">\n");
      out.write("              <p>Payment options:</p>\n");
      out.write("              <div class=\"card-wrap ps-2\">\n");
      out.write("                <img src=\"image/visa.jpg\" alt=\"visa\">\n");
      out.write("                <img src=\"image/mastercard.jpg\" alt=\"mastercard\">\n");
      out.write("                <img src=\"image/paypal.jpg\" alt=\"paypal\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-4 col-sm-6\">\n");
      out.write("            <div class=\"copyright\">\n");
      out.write("              <p>© Copyright 2024 TinStore. Founded by <a href=\"https://templatesjungle.com/\">PhamTrungTin</a> \n");
      out.write("              </p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
