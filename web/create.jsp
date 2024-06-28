<%@page import="user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
        <!--Stylesheet-->
        <style media="screen">
            *,
            *:before,
            *:after{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            body{
                background-color: #080710;
            }
            .background{
                width: 430px;
                height: 520px;
                position: absolute;
                transform: translate(-50%,-50%);
                left: 50%;
                top: 50%;
            }
            .background .shape{
                height: 200px;
                width: 200px;
                position: absolute;
                border-radius: 50%;
            }
            .shape:first-child{
                background: linear-gradient(
                    #1845ad,
                    #23a2f6
                    );
                left: -80px;
                top: -80px;
            }
            .shape:last-child{
                background: linear-gradient(
                    to right,
                    #ff512f,
                    #f09819
                    );
                right: -30px;
                bottom: -80px;
            }
            form{
                height: auto;
                width: 400px;
                background-color: rgba(255,255,255,0.13);
                position: absolute;
                transform: translate(-50%,-50%);
                top: 50%;
                left: 50%;
                border-radius: 10px;
                backdrop-filter: blur(10px);
                border: 2px solid rgba(255,255,255,0.1);
                box-shadow: 0 0 40px rgba(8,7,16,0.6);
                padding: 50px 35px;
            }
            h1{
                font-size: 40px;
                font-weight: inherit;
                font-size-adjust: 40px;
            }
            form *{
                font-family: 'Poppins',sans-serif;
                color: #ffffff;
                letter-spacing: 0.5px;
                outline: none;
                border: none;
            }
            form h3{
                color: #ff6e6e;
                font-size: 15px;
                font-weight: 350;
                line-height: 42px;
                text-align: center;
            }

            label{
                display: block;
                margin-top: 20px;
                font-size: 16px;
                font-weight: 500;
            }
            form input{
                display: block;
                height: 50px;
                width: 100%;
                background-color: rgba(255,255,255,0.07);
                border-radius: 3px;
                padding: 0 10px;
                margin-top: 8px;
                font-size: 14px;
                font-weight: 300;
            }
            ::placeholder{
                color: #e5e5e5;
            }
            button {
                margin-top: 20px;
                width: 100%;
                background-color: #ffffff;
                color: #080710;
                padding: 10px 0;
                font-size: 18px;
                font-weight: 600;
                border-radius: 5px;
                cursor: pointer;
            }
            button.login {
                color: #080710;
                font-size: 18px;
                font-weight: 600;


            }
            .social{
                margin-top: 30px;
                display: flex;
            }
            .social div{
                background: red;
                width: 150px;
                border-radius: 3px;
                padding: 5px 10px 10px 5px;
                background-color: rgba(255,255,255,0.27);
                color: #eaf0fb;
                text-align: center;
            }
            .social div:hover{
                background-color: rgba(255,255,255,0.47);
            }
            .social .fb{
                margin-left: 25px;
            }
            .social i{
                margin-right: 4px;
            }
            form .links{
                padding-top: 20px;
            }

        </style>
    </head>

    <body>
        <div class="background">
            <div class="shape"></div>
            <div class="shape"></div>
        </div>

        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>
        
        <form class="form" action="MainController" method="POST">
            <h1> Input your information </h1>
            <div class="inputBox"> 
                <input type="text" name="userId" required="" placeholder="User ID"/> 
                <h3> <%= userError.getUserID()%> </h3>
            </div>
            <div class="inputBox"> 
                <input type="text" name="userName" required="" placeholder="Name"/><i></i>
                <h3><%= userError.getFullName()%></h3>
            </div>
            <div class="inputBox"> 
                <input type="text" name="mail" required="" placeholder="Email"/><i></i>
                <h3><%= userError.getMail()%></h3>
            </div>
            <div class="inputBox"> 
                <input type="text" name="phone" required="" placeholder="Phone Number"/><i></i>
                <h3><%= userError.getPhone()%></h3>
            </div>

            <div class="inputBox"> 
                <input type="text" name="address" required="" placeholder="Adress"/>
            </div>
            <input type="hidden" name="role" value="US"/>
            <div class="inputBox"> 
                <input type="password" name="password" required="" placeholder="Password"/>
            </div>
            <div class="inputBox"> 
                <input type="password" name="confirm" required="" placeholder="Confirm"/>
                <h3> <%= userError.getConfirm()%></h3>
            </div>
            <div class="inputBox"> 
                <button type="submit" name="action"  value="Create">Create</button>
            </div>

        </form>

    </body>
</html>
