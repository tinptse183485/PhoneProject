<%-- 
    Document   : user
    Created on : May 24, 2024, 3:52:28 PM
    Author     : ADMIN
--%>

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
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        %>
        <h1>Welcome: <%= loginUser.getUserName() %></h1>
        <div>
            <form action="MainController" method="post">
                <button name="action" value="Logout">Log Out</button>
            </form>
        </div>
        
        <div>
            <form action="MainController" method="POST">
                <legend>SEARCH PHONE</legend>
                <div>
                    <input type="text" name="min" placeholder="Min Price" />
                    <input type="text" name="max" placeholder="Max Price" />
                </div>
                <div>
                    <button type="submit" name="action" value="SEARCH">SEARCH</button>
                </div>
            </form>
        </div>

        <div>
            <%
                List<ProductDTO> list = (List<ProductDTO>) session.getAttribute("LIST_PHONE");
                if (list != null) {
            %>
            <table border ="1">
                <tr>
                    <th>Phone ID</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Phone Name</th>
                    <th>Year of Production</th>
                    <th>Quantity</th>
                    <th>Not Sale</th>
                    <th>Add To Cart</th>
                </tr>
                <%
                    if(!list.isEmpty()){
                        for(ProductDTO phone: list){
                %>
                <form action="MainController" method="post">
                    <tr>
                        <td><%= phone.getMobileId() %></td>
                        <td><%= phone.getDescription() %></td>
                        <td><%= phone.getFormattedPrice() %></td>
                        <td><%= phone.getMobileName() %></td>
                        <td><%= phone.getYearOfProduction() %></td>
                        <td><%= phone.getQuantity() %></td>
                        <td>
                            <% if (phone.isNotSale()) { %>
                                not sale
                            <% } else { %>
                                sale
                            <% } %>
                        </td>
                        <td>
                            <input type="hidden" name="mobileId" value="<%= phone.getMobileId() %>" />
                            <input type="hidden" name="description" value="<%= phone.getDescription() %>" />
                            <input type="hidden" name="price" value="<%= phone.getPrice() %>" />
                            <input type="hidden" name="mobileName" value="<%= phone.getMobileName() %>" />
                            <input type="hidden" name="yearOfProduction" value="<%= phone.getYearOfProduction() %>" />
                            <input type="hidden" name="notSale" value="<%= phone.isNotSale() %>" />
                            <input type="hidden" name="quantity" value="<%= phone.getQuantity() %>" />
                            <button type="submit" name="action" value="ADD">Add to Cart</button>
                        </td>
                    </tr>
                </form>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="7">No results found</td>
            </tr>
            <%
                }
            %>
            </table>
            <%
                }
            %>
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
            <form action="MainController" method="POST" >
                <input type="submit"  name="action" value="View" />
            </form>
        </div>
    </body> 
</html>
