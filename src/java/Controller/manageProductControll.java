/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.productDao;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Aver
 */
@WebServlet(name = "manageProductControll", urlPatterns = {"/manageProductControll"})
public class manageProductControll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet manageProductControll</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageProductControll at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String proName = request.getParameter("name");
        String proCat = request.getParameter("category");
        int page = Integer.parseInt(request.getParameter("page"));
        productDao db = new productDao();
        List<Product> product = db.getProductByCondition(proName, proCat, page, 10);
        List<Category> cat = db.getAllCategory();
        int total = db.totalProductByCondition(proName, proCat);
        request.setAttribute("cat", cat);
        request.setAttribute("name", proName);
        request.setAttribute("category", proCat);
        request.setAttribute("page", page);
        request.setAttribute("pro", product);
        request.setAttribute("total", Math.ceil((double) total / 10));
        request.getRequestDispatcher("manage_product.jsp").forward(request, response);
        return;
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
        int productId = Integer.parseInt(request.getParameter("productId"));
        productDao db = new productDao();
        int status = db.deleteProduct(productId);
        if (status != 1) {
            response.sendRedirect("error");
            return;
        }
        response.sendRedirect("manageProductControll?name=&category=productId&=asc&page=1");
        return;
        
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
