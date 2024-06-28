/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.CartDAO;
import cart.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.ProductDAO;
import product.ProductDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "user.jsp";
    private static final String SUCCESS = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            CartDAO dao = new CartDAO();
            String userID = request.getParameter("userID").trim();
            String mobileId = request.getParameter("mobileId");
            float price = Float.parseFloat(request.getParameter("price"));
            String invId = request.getParameter("invId");
            String image = request.getParameter("image");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float totalPrice = price * quantity;
            String cartId = "P" + new Random().nextInt(10000);

            // Check if the glasses already exist in the cart
            CartDTO existingCart = dao.getCartByGlassesId(mobileId, userID);
            
            if (existingCart != null) {
                // If the glasses already exist in the cart, update the quantity
                existingCart.setQuantity(existingCart.getQuantity() + quantity);
                existingCart.setTotalPrice(price * existingCart.getQuantity());
                boolean check = dao.updateCart(existingCart);
                if (check) {
                    request.setAttribute("message", "Updated quantity of item in cart successfully.");
                } else {
                    request.setAttribute("message", "Failed to update quantity of item.");
                }
            } else {
                // If the glasses do not exist in the cart, add a new entry

                boolean check = dao.addToCart(cartId, mobileId, price, totalPrice, quantity, image, userID, invId);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("message", "Add to cart successfully.");
                } else {
                    request.setAttribute("message", "Failed to add to cart.");
                }
            }

        } catch (Exception e) {
            System.out.println("xui");
            log("Error at AddToCartController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
