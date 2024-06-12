/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.ProductDAO;
import product.ProductDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String SUCCESS = "SearchController";
    private static final String ERROR = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String mobileId = request.getParameter("mobileId");
            String description = request.getParameter("description");
            String mobileBrand = request.getParameter("mobileBrand");
            String mobileName = request.getParameter("mobileName");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float sale = Float.parseFloat(request.getParameter("sale"));
            String image = request.getParameter("image");
           
            
            if(price<0) 
            {
                request.setAttribute("ERROR", "Nhập giá lớn hơn hoặc bằng 0, buôn bán ít nhất cũng phải hòa vốn ");
                request.getRequestDispatcher(url).forward(request, response);
            }
            
            if(quantity<0) 
            {
                request.setAttribute("ERROR", "Nhập số lượng lớn hơn hoặc bằng 0 nhé");
                request.getRequestDispatcher(url).forward(request, response);
            }
            if(sale>1 && sale<0){
                request.setAttribute("ERROR", "Invalid sale, (0<sale<1)");
                request.getRequestDispatcher(url).forward(request, response);
                
            }
           
           
            ProductDTO product = new ProductDTO(mobileId, description, price, mobileName, mobileBrand, quantity, sale, image);
            ProductDAO dao = new ProductDAO();
            boolean checkUpdate = dao.update(product);
            if (checkUpdate) {
                request.setAttribute("MESSAGE", "update thanh cong");
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "update that bai");
            }
        } catch (Exception e) {
            log("Error at Update Controller" + e.toString());
            request.setAttribute("ERROR", "Update that bai");
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
