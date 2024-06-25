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

/**
 *
 * @author hd
 */
@WebServlet(name = "MainController", urlPatterns = {"/Maincontroller"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String REMOVEC = "REMOVEC";
    private static final String REMOVEC_CONTROLLER = "RemoveCartServlet";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String SEARCH_USER = "SearchUser";
    private static final String SEARCH_USER_CONTROLLER = "SearchUserController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteUserController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String UPDATE_USER_CONTROLLER = "UpdateUserController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String CREATE = "Create";
    private static final String CREATE_CONTROLLER = "CreateController";
    private static final String ADD = "Add More";
    private static final String ADD_NEW_ITEMS = "Add New Items";
    private static final String ADD_ITEM = "AddController";
    private static final String ADD_CART = "Add to cart";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartServlet";
    private static final String VIEW = "View";
    private static final String VIEW_CART = "ViewCart.jsp";
    private static final String CHANGE = "Change";
    private static final String CHANGE_CONTROLLER = "ChangeController";
    private static final String REMOVE = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveController";
    private static final String REMOVE_CART = "RemoveCart";
    private static final String REMOVE_CART_CONTROLLER = "RemoveCartController";
    private static final String Search_Phone_Price = "SEARCH";
    private static final String Search_Phone_Price_CONTROLLER = "searchPhoneByPriceServlet";
    private static final String Buy = "Buy";
    private static final String Buy_CONTROLLER = "BuyServlet";
    private static final String BACK_MENU = "Back Menu";
    private static final String BACK_MENU_CONTROLLER = "admin.jsp";
    private static final String CONTINUE_SHOPPING = "Continue shopping";
    private static final String CONTINUE_SHOPPING_CONTROLLER = "user.jsp";
    private static final String SAMSUNG = "SAMSUNG";
    private static final String APPLE = "APPLE";
    private static final String LENOVO = "LENOVO";
    private static final String OPPO = "OPPO";
    private static final String CATEGORY_CONTROLLER = "CategoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            String user = request.getParameter("actionUser");
            String brand = request.getParameter("brand");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;

            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (Search_Phone_Price.equals(action)) {
                url = Search_Phone_Price_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (UPDATE.equals(user)) {
                System.out.println("1");
                url = UPDATE_USER_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (ADD_CART.equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (ADD.equals(action)) {
                url = ADD_ITEM;
            }else if (ADD_NEW_ITEMS.equals(action)) {
                url = ADD_ITEM;
            } else if (VIEW.equals(action)) {
                url = VIEW_CART;
            } else if (CHANGE.equals(action)) {
                url = CHANGE_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            }else if (REMOVEC.equals(action)) {
                url = REMOVEC_CONTROLLER;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_USER_CONTROLLER;
            }else if (Buy.equals(action)) {
                url = Buy_CONTROLLER;
            }else if (BACK_MENU.equals(action)) {
                url = BACK_MENU_CONTROLLER;
            }else if (CONTINUE_SHOPPING.equals(action)) {
                url = CONTINUE_SHOPPING_CONTROLLER;
            }else if (REMOVE_CART.equals(action)) {
                url = REMOVE_CART_CONTROLLER;
            }else if (APPLE.equals(brand) ||SAMSUNG.equals(brand) ||OPPO.equals(brand) ||LENOVO.equals(brand) ) {
                url = CATEGORY_CONTROLLER;
            } else {
               
                request.setAttribute("ERROR", "Your action not support");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
