<%-- 
    Document   : user
    Created on : May 24, 2024, 3:52:28 PM
    Author     : ADMIN
--%>

<%@page import="product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="product.ProductDTO"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <script>
            function showSuccessMessage() {
                alert("Book added successfully to cart");
            }
        </script>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       

        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");

            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = null;
            if (request.getAttribute("LIST_PRODUCT") != null) {
                listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            } else {
                listProduct = dao.getAllProducts();
            }
        %>
        <h1>Welcome: <%= loginUser.getUserName()%></h1>
        <div>
            <form action="MainController" method="post">
                <button name="action" value="Logout">Log Out</button>
            </form>
        </div>

       
        <section class="py-5">
             <div>
            <form action="MainController" method="POST">
                <legend>Categories</legend>
                <div>
                    <input type="checkbox" id="C" name="C" value="C"/>
                </div>
                <div>
                    <input type="text" name="min" name="fromPrice" placeholder="Min Price" />
                    <input type="text" name="max" name="toPrice"placeholder="Max Price" />
                </div>
                <div>
                    <button type="submit" name="action" value="SEARCH">SEARCH</button>
                </div>
            </form>
        </div>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <%  for (ProductDTO product : listProduct) {
                    %>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img style="width:100%; height:250px"class="card-img-top" src="image/<%= product.getImage()%>" alt="...">
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%= product.getMobileName()%></h5>
                                    <!-- Product price-->
                                    <%  if (product.getPrice() != product.newPrice()) {
                                    %>
                                    <div>
                                        <span class="old-price">$<%=product.getPrice()     %></span>
                                        <span class="new-price">         $<%=product.newPrice()%></span>
                                    </div>
                                    <% } else {
                                    %> <span>$<%=product.getPrice()%></span>
                                    <%}%>
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                    
                    


                </div>
                    
            </div>
              </div>
            <%
                String successMessage = (String) request.getAttribute("SUCCESS");
                String errorMessage = (String) request.getAttribute("ERROR");
                if (successMessage != null) {
            %>
                <div style="color: red; text-align: center; margin-top: 20px;">
                    <%= successMessage %>
                </div>
            <%
                }
                if (errorMessage != null) {
            %>
                <div style="color: red; text-align: center; margin-top: 20px;">
                    <%= errorMessage %>
                </div>
            <%
                }
            %>
        <div>     
        </section>

    </body> 
</html>
