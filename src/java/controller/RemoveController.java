package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.ProductDAO;

@WebServlet(name = "RemoveController", urlPatterns = {"/RemoveController"})
public class RemoveController extends HttpServlet {
    private static final String SEARCH_PAGE = "SearchController"; 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("mobileId");
        try {
            ProductDAO dao = new ProductDAO();
            dao.removeProduct(productId);
            request.setAttribute("MESSAGE", "REMOVE SUCCESSFULLY");
            
            request.getRequestDispatcher(SEARCH_PAGE).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
