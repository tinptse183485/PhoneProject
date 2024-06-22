/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    private static final String ERROR="user.jsp";
    private static final String SUCCESS="user.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String mobileId = request.getParameter("mobileId");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String mobileName = request.getParameter("mobileName");
            String image =request.getParameter("image");
            String mobileBrand = request.getParameter("mobileBrand");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            List<ProductDTO> cart = (List<ProductDTO>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }

            boolean found = false;
            for (ProductDTO product : cart) {
                if (product.getMobileId().equals(mobileId)) {
                    product.setQuantity(product.getQuantity() + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(new ProductDTO(mobileId, description, price, mobileName, mobileBrand, quantity, price, image));
            }

            session.setAttribute("cart", cart);

            // Update the quantity in the stock
            List<ProductDTO> phoneList = (List<ProductDTO>) session.getAttribute("LIST_PHONE");
            if (phoneList != null) {
                for (ProductDTO phone : phoneList) {
                    if (phone.getMobileId().equals(mobileId)) {
                        phone.setQuantity( phone.getQuantity()- 1);
                        break;
                    }
                }
                session.setAttribute("LIST_PHONE", phoneList);
            }

            url = SUCCESS;
            request.setAttribute("SUCCESS", "Product added to cart successfully!");
        } catch (Exception e) {
            log("Error at AddToCartServlet: " + e.toString());
            request.setAttribute("ERROR", "Error occurred while adding product to cart.");
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
