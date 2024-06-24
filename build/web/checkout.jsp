<%@page import="cart.CartDTO"%>

<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page import="Invoice.InvoiceDTO"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">


    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
    
  </head>
  <body>
  <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
           
        %>    


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

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_dateBuy" class="text-black">Date of Purchase <span class="text-danger">*</span></label>
                        <input type="datetime-local" class="form-control" id="c_dateBuy" name="dateBuy">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_gmail" class="text-black">Email <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_gmail" name="gmail"value="<%=loginUser.getGmail()%>" placeholder="Enter email">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-md-12">
                        <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_address" name="address" value="<%=loginUser.getAddress()%>"placeholder="Enter address">
                    </div>
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
                                    <td><%=cart.getIdGlasses()%> <strong class="mx-2">x</strong> <%=cart.getQuantity()%></td>
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
                        <button type="submit"name="action" value="CreateInvoice" class="btn btn-primary btn-lg py-3 btn-block">Place Order</button>
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