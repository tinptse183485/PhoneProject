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
        <title>TinStore</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="format-detection" content="telephone=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="author" content="">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap" rel="stylesheet">

    <link href="styleManager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
          <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

        %>    
         <header id="header" class="site-header header-scrolled position-fixed text-black bg-light">
            <nav id="header-nav" class="navbar navbar-expand-lg px-3 mb-3">
                <div class="container-fluid">
                    <a class="navbar-brand" href="user.jsp">
                        <h1>  TinStore</h1>
                    </a>
                    <button class="navbar-toggler d-flex d-lg-none order-3 p-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#bdNavbar" aria-controls="bdNavbar" aria-expanded="false" aria-label="Toggle navigation">
                        <svg class="navbar-icon">
                        <use xlink:href="#navbar-icon"></use>
                        </svg>
                    </button>
                    <div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar" aria-labelledby="bdNavbarOffcanvasLabel">
                        <div class="offcanvas-header px-4 pb-0">
                            <a class="navbar-brand" href="home.html">
                                <img src="image/main-logo.png" class="logo">
                            </a>
                            <button type="button" class="btn-close btn-close-black" data-bs-dismiss="offcanvas" aria-label="Close" data-bs-target="#bdNavbar"></button>
                        </div>
                        <div class="offcanvas-body">
                            <ul id="navbar" class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">


                                <li class="nav-item">
                                    <div style="margin-top:1.5rem" class="user-items ps-5">
                                        <ul class="d-flex justify-content-end list-unstyled">
                                           

                                            <li class="search-item pe-3">
                                                <a href="home.jsp" class="search-button">
                                                    <div>
                                                        <form action="MainController" method="post">
                                                            <button style="border:none" name="action" value="Logout">Log Out</button>
                                                        </form>
                                                    </div>
                                                </a>
                                            </li>
                                            <li class="pe-3">
                                                <a href="#">
                                                    <p style="color:#212529"><%= loginUser.getUserName()%><p>
                                                </a>
                                            </li>
                                            
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
        </header>

 <div class="hid">
        </br>
        </br>
        </br>
        </br>
        </br>
        </br>

    </div>
      
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
                                            <img style="width:170px ;height: 170px"src="image/<%=cart.getImage()%>" alt="Image" class="img-fluid">
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
                                            <button name="action"value="RemoveCart" class="btn btn-primary btn-sm">X</button>
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
                                <%
                                    String error = (String) request.getAttribute("cart");
                                    if (error == null) {
                                        error = "";
                                    }
                                %>
                                <div class="d-flex justify-content-center">
                                    <h3 style="color: greenyellow;"><%= message%></h3>
                                </div>  
                                 <div class="d-flex justify-content-center">
                                    <h3 style="color: red;"><%= error%></h3>
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
                                            <footer id="footer" class="overflow-hidden">
      <div style="margin-top:2em"class="container">
        <div class="row mainn">
          <div class="footer-top-area">
            <div class="row d-flex flex-wrap justify-content-between">
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu">
                  <h1>TinStore</h1>
                  <p>Your attentions is our happiness and motivation to develop more qualified products.</p>
                  <div class="social-links">
                    <ul class="d-flex list-unstyled">
                      <li>
                        <a href="#">
                          <svg class="facebook">
                            <use xlink:href="#facebook" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="instagram">
                            <use xlink:href="#instagram" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="twitter">
                            <use xlink:href="#twitter" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="linkedin">
                            <use xlink:href="#linkedin" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="youtube">
                            <use xlink:href="#youtube" />
                          </svg>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-lg-2 col-sm-6 pb-3">
                <div class="footer-menu text-uppercase">
                  <h5 class="widget-title pb-2">Quick Links</h5>
                  <ul class="menu-list list-unstyled text-uppercase">
                    <li class="menu-item pb-2">
                      <a href="#">Home</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">About</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Shop</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Blogs</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Contact</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu text-uppercase">
                  <h5 class="widget-title pb-2">Help & Info Help</h5>
                  <ul class="menu-list list-unstyled">
                    <li class="menu-item pb-2">
                      <a href="#">Track Your Order</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Returns Policies</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Shipping + Delivery</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Contact Us</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Faqs</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu contact-item">
                  <h5 class="widget-title text-uppercase pb-2">Contact Us</h5>
                  <p>Do you have any queries or suggestions? <a href="mailto:">tinptse183485@fpt.edu.vn</a>
                  </p>
                  <p>If you need support? Just give us a call. <a href="">0899 452 877</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <hr>
    </footer>
    <div id="footer-bottom">
      <div class="container">
        <div class="row d-flex flex-wrap justify-content-between">
          <div class="col-md-4 col-sm-6">
            <div class="Shipping d-flex">
              <p>We ship with:</p>
              <div class="card-wrap ps-2">
                <img src="image/dhl.png" alt="visa">
                <img src="image/shippingcard.png" alt="mastercard">
              </div>
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="payment-method d-flex">
              <p>Payment options:</p>
              <div class="card-wrap ps-2">
                <img src="image/visa.jpg" alt="visa">
                <img src="image/mastercard.jpg" alt="mastercard">
                <img src="image/paypal.jpg" alt="paypal">
              </div>
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="copyright">
              <p>© Copyright 2024 TinStore. Founded by <a href="https://templatesjungle.com/">PhamTrungTin</a> 
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
            </div>
        </div>
    </body>
</html>
