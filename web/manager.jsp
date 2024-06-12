<%-- 
    Document   : manager
    Created on : Jun 3, 2024, 7:40:19 PM
    Author     : ASUS
--%>

<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="logOut" action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <div class="container">



            <div class="content">
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
                <div class="welcome">   
                    <h1 >
                        WELCOME
                    </h1>
                    <h2><%= loginUser.getUserName()%></h2>
                </div>

                <form class="search" action="MainController">
                    <div >
                        <input style="width:300px" type="text" name="search" value="<%= search%>"/>
                    </div>
                    <div>
                        <input type="submit" name="action" value="SearchUser"/>
                    </div>

                </form>
                <%
                    List<UserDTO> listUser = (List) request.getAttribute("LIST_USER");
                    if (listUser != null) {
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
                            <th class="header">Password</th>
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
                            <td> <input styletype="text" name="password" value"<%= user.getPassword()%>" readonly="" /> </td>
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
<%
    String error = (String) request.getAttribute("ERROR");
    if (error == null) {
        error = "";
    }
%>
<%= error%>


<%
        }
    }

    String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }
%>
<%= message%>

</body>
</html>
