package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.ProductDAO;
import product.ProductDTO;

@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {

    private static final String SUCCESS = "staff.jsp";
    private static final String ERROR = "addPhone.jsp";
    private static final String REG_FLOAT = "[+-]?([0-9]*[.])?[0-9]+";
    private static final String REG_INT = "[0-9]+";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        ProductDAO dao = new ProductDAO();
        ProductDTO product = new ProductDTO();

        try {
            String mobileId = request.getParameter("mobileId");
            String mobileName = request.getParameter("mobileName");
            String description = request.getParameter("description");
            String mobileBrand = request.getParameter("mobileBrand");
            String image = request.getParameter("image");

            double price = Double.parseDouble(request.getParameter("price"));
            double sale = Double.parseDouble(request.getParameter("sale"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            boolean checkDuplicate = dao.checkDuplicate(mobileId);
            if (checkDuplicate) {
                request.setAttribute("MESSAGE", "Duplicated ID");
                request.getRequestDispatcher(url).forward(request, response);
            }
            if (price < 0) {
                request.setAttribute("MESSAGE", "Nhập giá lớn hơn hoặc bằng 0, buôn bán ít nhất cũng phải hòa vốn ");
                request.getRequestDispatcher(url).forward(request, response);
            }

            if (quantity < 0) {
                request.setAttribute("MESSAGE", "Nhập số lượng lớn hơn hoặc bằng 0 nhé");
                request.getRequestDispatcher(url).forward(request, response);
            }

            product = new ProductDTO(mobileId, description, price, mobileName, mobileBrand, quantity, sale, image);

            if (dao.addProduct(product)) {

                request.setAttribute("MESSAGE", "Sản phẩm đã được thêm vào list.");
                url = SUCCESS;
            } else {

                request.setAttribute("MESSAGE", "Thêm ko thành công");
                url = ERROR;
            }

        } catch (Exception e) {
            if (!request.getParameter("price").matches(REG_FLOAT) && request.getParameter("price") != null) {
                request.setAttribute("MESSAGE", "Nhập giá là số thực ");
                request.getRequestDispatcher(url).forward(request, response);
            }

            if (!request.getParameter("sale").matches(REG_FLOAT) && request.getParameter("sale") != null) {
                request.setAttribute("MESSAGE", "Nhập sale là số thực ");
                request.getRequestDispatcher(url).forward(request, response);
            }

            if (!request.getParameter("quantity").matches(REG_INT) && request.getParameter("quantity") != null) {
                request.setAttribute("MESSAGE", "Nhập số lượng là số nguyên ");
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                request.setAttribute("MESSAGE", "Nhập đầy đủ thông tin i");
                request.getRequestDispatcher(ERROR).forward(request, response);
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }
}
