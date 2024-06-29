<%-- 
    Document   : manager
    Created on : Jun 3, 2024, 7:40:19 PM
    Author     : ASUS
--%>

<%@page import="user.UserDAO"%>
<%@page import="product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
        <!-- script
         ================================================== -->
        <script src="js/modernizr.js"></script>
    </head>
    <body>



        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRole().equals("MA")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <header id="header" class="site-header header-scrolled position-fixed text-black bg-light">
            <nav id="header-nav" class="navbar navbar-expand-lg px-3 mb-3">
                <div class="container-fluid">
                    <a class="navbar-brand" href="manager.jsp">
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
                                            <li class="nav-item">
                                                 <a class="nav-link me-4 active" href="invoice.jsp">Manage Invoice</a>
                                            </li>

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

 <div class="content">
        <form class="search " action="MainController">
            <div class="row" style="text-align: center">
            <div class="col-md-12" >
                <input style="width:300px" type="text" name="search" value="<%= search%>" placeholder="Search by Name"/>
            </div>
            <div class="col-md-12">
                <input type="submit" name="action" value="SearchUser"/>
            </div>
            </div>

        </form>
            <%
    String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }
%>
<h2 style="color:#86da04"><%= message%></h2>
<%
    String error = (String) request.getAttribute("ERROR");
    if (error == null) {
        error = "";
    }
%>
<h2 style="color:red"><%= error%></h2>
        <%
            List<UserDTO> listUser = (List) request.getAttribute("LIST_USER");
            if (listUser == null){
                UserDAO dao= new UserDAO();
                listUser=dao.getListUser("");
            }
            
                if (listUser.size() > 0) {
        %>
        <table >
            <thead>
                <tr>
                    <th class="header">No</th>
                    <th class="header">User ID</th>
                    <th class="header">Full Name</th>
                    <th class="header">Role ID</th>
                    <th class="header">Mail</th>
                    <th class="header">Phone Number</th>
                    <th class="header">Address</th>
                    <th class="header">Delete</th>
                    <th class="header">Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {

                %>
            <form action="MainController" method="POST">
                <tr>
                    <td > <input type="text" name="No" value="<%= count++%>" readonly=""/> </td>
                    <td>
                        <input type="text" name="userId" value="<%= user.getUserID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="userName" value="<%= user.getUserName()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="role"  value="<%= user.getRole()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="mail"  value="<%= user.getMail()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="phone"  value="<%= user.getPhone()%>" required=""/>
                    </td>
                        <input type="hidden" name="password" value="<%= user.getPassword()%>" />
                    <td> <input type="text" name="address" value="<%= user.getAddress()%>" required="" /> </td>
                    <!--detele o day ne-->
                    <td>
                        <a href="MainController?userID=<%= user.getUserID()%>&action=Delete&search=<%= search%>">Delete</a>
                    </td>
                    <!--update i day ne-->  
                    <td>
                        <input type="submit" name="actionUser" value="Update"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </div>
    </div>

</tbody>
</table>
</div>




<%
        
    }
%>

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

</body>
</html>
