/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.productDao;
import Model.Category;
import Model.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 *
 * @author Aver
 */
@WebServlet(name = "updateProductController", urlPatterns = {"/updateProductController"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class updateProductController extends HttpServlet {

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
            out.println("<title>Servlet updateProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProductController at " + request.getContextPath() + "</h1>");
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
        int productId = Integer.valueOf(request.getParameter("productId"));
        productDao db = new productDao();
        Product product = db.getProductByID(productId);
        List<Category> category = db.getAllCategory();
        request.setAttribute("category", category);
        request.setAttribute("product", product);
        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
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
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int stats = Integer.valueOf(request.getParameter("status"));
        int category = Integer.parseInt(request.getParameter("category"));
        String descript = request.getParameter("descript");
        Part file = request.getPart("file");
        productDao db = new productDao();
        Product product = db.getProductByID(productId);
        String thumnail = "";
//        String imgSlide = "";
        if (extractFileName(file).equals("")) {
            thumnail = product.getImage();
        } else {
            thumnail = extractFileName(file);
            // refines the fileName in case it is an absolute path
            thumnail = new File(thumnail).getName();
            file.write(this.getFolderUpload().getAbsolutePath() + File.separator + thumnail);
        }
//        if (extractFileName(slide).equals("")) {
//            imgSlide = film.getImageSlide();
//        } else {
//            imgSlide = extractFileName(slide);
//            // refines the fileName in case it is an absolute path
//            imgSlide = new File(imgSlide).getName();
//            slide.write(this.getFolderUpload().getAbsolutePath() + File.separator + imgSlide);
//        }
        int status = db.updateProduct(category, productName, thumnail, price, stats, descript, productId);
        if (status != 1) {
            response.sendRedirect("error");
        } else {
            response.sendRedirect("manageProductControll?productName=&category=&productId=asc&page=1");
        }

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

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload() {
        File folderUpload = new File("C:\\Users\\Aver\\Documents\\NetBeansProjects\\Mirano\\web\\View\\image");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
