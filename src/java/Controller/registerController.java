/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDao;
import Model.Email;
import Model.EmailUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author Aver
 */
@WebServlet(name = "registerController", urlPatterns = {"/registerController"})
public class registerController extends HttpServlet {

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
            out.println("<title>Servlet registerController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String emailAddress = request.getParameter("email");
        String pass = request.getParameter("pass");
        String rePass = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        boolean gender = request.getParameter("gender").equals("true") ? true : false;
        HttpSession session= request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", emailAddress);
        session.setAttribute("pass", pass);
        session.setAttribute("repass",rePass);
        session.setAttribute("phone", phone);
        session.setAttribute("address", address);
        session.setAttribute("gender", gender);
        RequestDispatcher dispatcher = null;
        int otpvalue =0;
        UserDao db = new UserDao();
        User u = db.findUser(emailAddress);
        if (u != null) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if (!pass.equals(rePass)) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        } else {
            try{
                                Random rand = new Random();
                                otpvalue = rand.nextInt(1255650);
				Email email =new Email();
				email.setFrom("mirano12121212@gmail.com");
				email.setFromPassword("tszeaqvxuewzzdbv");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(name).append("<br>");
				sb.append("You are used the register user. <br> ");
				sb.append("Your otp is <b>").append(otpvalue).append(" </b> <br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("mess", "OTP had sent to your email!");
                                session.setAttribute("otp", otpvalue); 
                                dispatcher = request.getRequestDispatcher("confirmRegisOtp.jsp");                  
                                dispatcher.forward(request, response);
            }catch(Exception e)
                {
			e.printStackTrace();
                }
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

}
