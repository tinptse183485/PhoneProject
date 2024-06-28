package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.ProductDAO;
import product.ProductDTO;

@WebServlet(name = "SearchMobileByNameController", urlPatterns = {"/SearchMobileByNameController"})
public class SearchMobileByNameController extends HttpServlet {

    private static final String ERROR = "user.jsp";
    private static final String SUCCESS = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String mobileName = request.getParameter("mobileName");
          

                ProductDAO dao = new ProductDAO();
                List<ProductDTO> listProduct = dao.searchbyName(mobileName);

                if (listProduct.isEmpty()) {
                    request.setAttribute("NO_RESULTS", "No search Results");
                } else {
                    request.setAttribute("LIST_PRODUCT", listProduct);
                    url=SUCCESS;
                }
            

        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SearchController handles product search functionality";
    }
}
