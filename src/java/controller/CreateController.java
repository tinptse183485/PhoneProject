/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;
import user.UserDTO;
import user.UserError;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
    private static final String REG_MAIL="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String REG_PHONE = "(0[3|5|7|8|9|1])+([0-9]{8,9})";
    private static final String ERROR="create.jsp";
    private static final String SUCCESS="login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        UserDAO dao= new UserDAO();
        UserError userError= new UserError();
        try {
            String userId= request.getParameter("userId");
            String userName= request.getParameter("userName");
            String role=request.getParameter("role");
            String mail= request.getParameter("mail");
            String phone= request.getParameter("phone");
            String password= request.getParameter("password");
            String confirm= request.getParameter("confirm");
            
            boolean checkValidation= true;
            if(userId.length()>50 || userId.length()<2){
                userError.setUserID("User ID Must [2,50]");
                checkValidation= false;
            }
            boolean checkDuplicate= dao.checkDuplicate(userId);
            if(checkDuplicate){
                userError.setUserID("Duplicate userID!");
                checkValidation= false;
            }
            
            if(userName.length()>50 || userName.length()<5){
                userError.setFullName("Full Name Must [5,50]");
                checkValidation= false;
            }
            if(!mail.matches(REG_MAIL))
            {   userError.setMail("Invalid Mail");
                checkValidation= false;
                
            }
            if(!phone.matches(REG_PHONE))
            {   userError.setMail("Invalid Phone Number");
                checkValidation= false;
                
            }
            
            if(!password.equals(confirm)){
                userError.setConfirm("Wrong Password Confirm!");
                checkValidation= false;
            }
            if(checkValidation){
                UserDTO user= new UserDTO(userId, userName, role, password, mail, phone);
                boolean checkInsert= dao.insertV2(user);
                if(checkInsert){
                    url= SUCCESS;
                    request.setAttribute("MESSAGE","Your account is created");
                }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateServlet: "+ e.toString());
            if(e.toString().contains("duplicate")){
                userError.setUserID("User ID Is Available!");
                request.setAttribute("USER_ERROR", userError);
            }
            
        }finally{
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
