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
import javax.servlet.http.HttpSession;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author hd
 */
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {

    private static final String ERROR = "SearchUserController";
    private static final String SUCCESS = "SearchUserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userId");
            String userName = request.getParameter("userName");
            String role = request.getParameter("role");
            if (!role.equalsIgnoreCase("MA") && !role.equalsIgnoreCase("US") && !role.equalsIgnoreCase("ST"))
            {
                request.setAttribute("ERROR", "Role must be MA/ST/US");
                request.getRequestDispatcher(url).forward(request, response);

            }
            String mail = request.getParameter("mail");
            String phone = request.getParameter("phone");

            UserDTO user = new UserDTO(userID, userName, role, "***", mail, phone);
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser.getUserID().equals(userID)) {
                loginUser.setUserName(userName);
                loginUser.setRole(role);
                loginUser.setMail(mail);
                loginUser.setPhone(phone);
                session.setAttribute("LOGIN_USER", loginUser);
            }
            boolean checkUpdate = dao.update(user);
            if (checkUpdate) {
                request.setAttribute("MESSAGE", "Update successfully!");
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Update fail!");
            }

        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
