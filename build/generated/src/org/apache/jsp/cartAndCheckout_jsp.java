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

public final class cartAndCheckout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

        
      out.write("    \n");
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
      out.write("                                            <img src=\"images/");
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
      out.write("                                            <div class=\"input-group mb-3\" style=\"max-width: 120px;\">\n");
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
      out.write("                                            <button name=\"action\"value=\"Remove\" class=\"btn btn-primary btn-sm\">X</button>\n");
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
      out.write("                                <a href=\"shop.jsp\" class=\"btn btn-outline-primary btn-sm btn-block\">Continue Shopping</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6 mb-3 mb-md-0\">\n");
      out.write("                                ");

                                    String message = (String) request.getAttribute("message");
                                    if (message == null) {
                                        message = "";
                                    }
                                
      out.write("\n");
      out.write("                                <div class=\"d-flex justify-content-center\">\n");
      out.write("                                    <h3 style=\"color: red;\">");
      out.print( message);
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
