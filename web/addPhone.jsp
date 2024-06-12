<%-- 
    Document   : addPhone
    Created on : Jun 11, 2024, 11:26:18 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="post">
            MobileID: <input type="text" name="mobileId"><br>
            imageName: <input type="text" name="image"><br>
            MobileBrand: <input type="text" name="mobileBrand"><br>
            MobileName: <input type="text" name="mobileName"><br>
            Description: <input type="text" name="description"><br>
            Price: <input type="text" name="price"><br>
            Sale: <input type="text" name="sale"><br>
            Quantity: <input type="text" name="quantity"><br>
            <a "><input  name="action" type="submit" value="Add More"></a>
        </form>

        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <div>
            <%= message%>
        </div>
    </body>
</html>
