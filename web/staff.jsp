<%-- 
    Document   : admin
    Created on : Sep 28, 2022, 5:10:03 PM
    Author     : hd
--%>

<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
     
    </head>
    <Style>

    </style>

    
    <body>  
   
         <form class="logOut" action="MainController" method="POST">
                <input type="submit" name="action" value="Logout"/>
          </form>
             <%
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
        %>
        <h1>Welcome <%= loginUser.getUserName()%></h1>

        
        <%
            if (request.getAttribute("ERROR") != null) {
        %>
        <script>
            alert("${requestScope.ERROR}");
        </script >         
         <%
                }
         %>


  

        <%  String fromPrice = request.getParameter("fromPrice");
            String toPrice = request.getParameter("toPrice");
            if (fromPrice == null) {
                fromPrice = "";
            }
            if (toPrice == null) {
                toPrice = "";
            }
        %>
        <form action="SearchController" method="POST">
            From Price: <input type="text" name="fromPrice" value="<%= fromPrice%>"/>
            To Price: <input type="text" name="toPrice" value="<%= toPrice%>"/>
            <input type="submit" value="Search"/>
        </form>

        <h2>Search Results</h2>
        <% if (noResults != null) {%>
        <p><%= noResults%></p>
        <% } else if (listProduct != null && !listProduct.isEmpty()) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>img</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Brand </th>
                    <th>Price</th>
                    <th>Sale</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (ProductDTO product : listProduct) {
                        double subtotal = product.getPrice() * product.getQuantity();
                %>
                <tr>
            <form action="MainController" method="post">
                <td><%= ++count%></td>
                <td><%= product.getMobileId()%></td>
                <td>
                <img style="width: 40%;height: 100%"src="image/<%= product.getImage()%>">
                </td>
                <td>
                    <input type="text" name="mobileName" value="<%= product.getMobileName()%>" required=""/>
                </td>
                 <td>
                    <input type="text" name="description" value="<%= product.getDescription()%>" required="" />
                </td>
                 <td>
                    <input type="text" name="mobileBrand" value="<%= product.getMobileBrand()%>" required="" />
                </td>
                <td>
                    <input type="number"  name="price" value="<%=  (float) product.getPrice()%>" required="" />
                </td>
                 <td>
                    <input type="number" step=".01"  name="sale" value="<%=  (float) product.getSale()%>" required="" />
                </td>
                
                <td>
                    <input type="number" name="quantity" value="<%= product.getQuantity()%>" required="" />
                </td>
                
                <td>
                    <input type="hidden" name="fromPrice" value="<%= fromPrice%>"/>
                    <input type="hidden" name="toPrice" value="<%= toPrice%>" />
                    <input type="hidden" name="mobileId" value="<%= product.getMobileId()%>"/>
                    <input type="submit" name="action" value="Remove"/>
                    <input type="submit" name="action" value="Update"/>
                </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <% } else { %>
      <p>No products found.</p>
    <% }%>
          <%
        String message = (String) request.getAttribute("MESSAGE");
        if (message == null) {
            message = "";
        }
    %>
    <div>
        <%= message%>
    </div>
<div>

<form action="addPhone.jsp">
<button type="submit"  > Add new items </button>
</form>
        </div>
    
   
</body>
</html>
