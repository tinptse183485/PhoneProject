<%-- 
    Document   : cartAndCheckout
    Created on : Jun 21, 2024, 9:56:55 AM
    Author     : ASUS
--%>


<%@page import="java.util.Random"%>
<%@page import="user.UserDTO"%>
<%@page import="cart.CartDTO"%>
<%@page import="cart.CartDAO"%>
<%@page import="java.util.List"%>
<%@page import="Invoice.InvoiceDTO"%>
<%@page import="Invoice.InvoiceDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

        %>    
        <div class="site-section">
            <%        CartDAO cartDAO = new CartDAO();
                List<CartDTO> cartList = null;

                if (loginUser != null) {

                    String userID = loginUser.getUserID();
                    cartList = cartDAO.getCart(userID);
                    session.setAttribute("cartList", cartList);

                }

            %>      
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-12" >
                        <div class="site-blocks-table">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th class="product-thumbnail">Image</th>
                                        <th class="product-name">Product</th>
                                        <th class="product-price">Price</th>
                                        <th class="product-quantity">Quantity</th>
                                        <th class="product-total">Total</th>
                                        <th class="product-remove">Remove</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% float totalCost = 0;

                                        String invId = (String) session.getAttribute("invId");
                                        if (invId == null) {
                                            invId = "INV-" + new Random().nextInt(10000);
                                            session.setAttribute("invId", invId);
                                        }
                                        if (cartList != null) { %>
                                    <% for (CartDTO cart : cartList) {
                                            cart.setInvId(invId);
                                            cartDAO.updateInvId(cart);
                                            totalCost += cart.getTotalPrice();%>
                                <form class="col-md-12"  action="MainController" method="POST">    
                                    <tr>
                                        <td class="product-thumbnail">
                                            <img style="width:30% ;height: 1rem"src="image/<%=cart.getImage()%>" alt="Image" class="img-fluid">
                                        </td>
                                        <td class="product-name">
                                            <h2 class="h5 text-black"><%=cart.getMobileId()%></h2>
                                        </td>
                                        <td><%=cart.getPrice()%></td>
                                        <td>
                                            <div class="input-group mb-3" style="width: 100%;">
                                                <input type="hidden" name="cartId" value="<%=cart.getCartId()%>">
                                                <input type="text" name="quantity"  value="<%=cart.getQuantity()%>">

                                                <button name="action" value="Change" type="submit" class="btn btn-primary btn-sm">Update</button>

                                            </div>
                                        </td>
                                        <td><%=cart.getTotalPrice()%></td>
                                        <td> 
                                            <input type="hidden" name="cartId" value="<%=cart.getCartId()%>">
                                            <button name="action"value="Remove" class="btn btn-primary btn-sm">X</button>
                                        </td>
                                    </tr>
                                </form>    
                                <% } %>
                                <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>





                <div class="row">
                    <div class="col-md-6">
                        <div class="row mb-5">

                            <div class="col-md-6">
                                <a href="user.jsp" class="btn btn-outline-primary btn-sm btn-block">Continue Shopping</a>
                            </div>
                            <div class="col-md-6 mb-3 mb-md-0">
                                <%
                                    String message = (String) request.getAttribute("message");
                                    if (message == null) {
                                        message = "";
                                    }
                                %>
                                <div class="d-flex justify-content-center">
                                    <h3 style="color: red;"><%= message%></h3>
                                </div>  
                            </div>
                        </div>

                    </div>
                    <div class="col-md-6 pl-5">
                        <div class="row justify-content-end">
                            <div class="col-md-7">
                                <div class="row">

                                    <div class="col-md-12 text-right border-bottom mb-5">
                                        <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                                    </div>
                                </div>

                                <div class="row mb-5">
                                    <div class="col-md-6">
                                        <span class="text-black">Total</span>
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <strong class="text-black">$<%=totalCost%></strong>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <%
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
                                        %>
                                        <div>
                                            <a href="checkout.jsp" class="btn btn-primary btn-lg py-3 btn-block">Go to Checkout</a>
                                        </div>     
                                        <%
                                            } else {
                                                request.setAttribute("message", "Cannot checkout");

                                            }%>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
