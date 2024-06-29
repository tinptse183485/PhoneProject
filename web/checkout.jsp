<%@page import="cart.CartDTO"%>

<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page import="Invoice.InvoiceDTO"%>
<!DOCTYPE html>
<html lang="en">
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
      <div class="container">
        <%
            InvoiceDTO invoice = (InvoiceDTO) session.getAttribute("invoice");
            
        %>
        <form action="CreateInvoiceController" method="POST">
        <div class="row">
          
          <div class="col-md-6 mb-5 mb-md-0">
            <h2 class="h3 mb-3 text-black">Billing Details</h2>
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_invId" class="text-black">Invoice ID</label>
                        <input type="text" class="form-control" id="c_invId" name="invId" value="<%=invoice.getInvId()%>" readonly>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_userID" class="text-black">User ID</label>
                        <input type="text" class="form-control" id="c_userID" name="userID" value="<%=loginUser.getUserID()%>" readonly>
                    </div>
                </div>

                
                        <input type="hidden" type="datetime-local" class="form-control" id="c_dateBuy" name="dateBuy">
                

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_gmail" class="text-black">Email <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_gmail" name="gmail"value="<%=loginUser.getMail()%>" placeholder="Enter email" required="">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_address" name="address" value="<%=loginUser.getAddress()%>"placeholder="Enter address" required="">
                    </div>
                </div>
                    <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_address" name="phone" value="<%=loginUser.getPhone()%>"placeholder="Enter Phone number" required="">
                    </div>
                </div>
                          <%String error = (String) request.getAttribute("error");
                                    if (error == null) {
                                        error = "";
                                    }
                                %>
                                <div class="d-flex justify-content-center">
                                    <h3 style="color: red;"><%= error%></h3>
                                </div>  

                <!-- Rest of your form here -->
            </div>
          </div>
                    
                    
          <div class="col-md-6">
            <div class="row mb-5">
            <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                    <table class="table site-block-order-table mb-5">
                        <thead>
                            <th>Product</th>
                            <th>Total</th>
                        </thead>
                        <tbody>
                            <% 
                            List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");
                            float totalCost = 0;
                            for (CartDTO cart : cartList) { 
                                totalCost += cart.getTotalPrice();
                            %>
                                <tr>
                                    <td><%=cart.getMobileId()%> <strong class="mx-2">x</strong> <%=cart.getQuantity()%></td>
                                    <td>$<%=cart.getTotalPrice()%></td>
                                </tr>
                            <% 
                            } 
                            %>
                            <tr>
                                <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                                <td class="text-black font-weight-bold"><strong>$<%=totalCost%></strong></td>
                            </tr>
                            
                        </tbody>
                    </table>
                    <div class="form-group">
                        <input type="hidden" name="total" value="<%=totalCost%>">
                        <button type="submit" name="action" value="CreateInvoice" class="btn btn-primary btn-lg py-3 btn-block">Place Order</button>
                      </div>
                </div>
            </div>
        </div>


          </div>
        </div>
        </form>
        <!-- </form> -->
      </div>
    </div>
                        

   
<footer id="footer" class="overflow-hidden">
      <div class="container">
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
   


  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>

    
  </body>
</html>